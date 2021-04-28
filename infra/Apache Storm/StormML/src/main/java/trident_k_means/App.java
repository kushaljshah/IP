package trident_k_means;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.github.pmerienne.trident.ml.clustering.ClusterQuery;
import com.github.pmerienne.trident.ml.clustering.ClusterUpdater;
import com.github.pmerienne.trident.ml.clustering.KMeans;
import com.github.pmerienne.trident.ml.core.Instance;
import com.github.pmerienne.trident.ml.preprocessing.InstanceCreator;
import com.github.pmerienne.trident.ml.testing.data.Datasets;

import storm.trident.TridentState;
import storm.trident.TridentTopology;
import storm.trident.testing.MemoryMapState;
import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.LocalDRPC;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.generated.StormTopology;
import backtype.storm.tuple.Fields;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws AlreadyAliveException, InvalidTopologyException
    {
        LocalDRPC drpc=new LocalDRPC();
        
        Config config=new Config();
        
        LocalCluster cluster=new LocalCluster();
        
        cluster.submitTopology("KMeansDemo", config, buildTopology(drpc));
        
        try{
        	Thread.sleep(10000);
        }catch(InterruptedException ex)
        {
        	ex.printStackTrace();
        }
        
        
        
        for(int i=0; i < 10; ++i)
        {
        	String drpc_args=generateRandomTestingArgs();
        	System.out.println(drpc.execute("predict", drpc_args));
        	try{
        		Thread.sleep(1000);
        	}catch(InterruptedException ex)
        	{
        		ex.printStackTrace();
        	}
        }
        
        cluster.killTopology("KMeansDemo");
        cluster.shutdown();
        drpc.shutdown();
    }
    
    private static String generateRandomTestingArgs()
    {
    	int batchSize=10;
    	int numFeatures=3;
    	int numClasses=3;
    	
    	final Random rand=new Random();
    	
    	List<Instance<Integer>> data = Datasets.
				generateDataForMultiLabelClassification(batchSize, numFeatures, numClasses);
		
		String args="";
		Instance<Integer> instance = data.get(rand.nextInt(data.size()));
		
		
		args+=instance.label;
		
		for(double feature : instance.getFeatures())
		{
			args+=(","+feature);
		}
			
		
		return args;
    }
    
    private static StormTopology buildTopology(LocalDRPC drpc)
    {
    	TridentTopology topology=new TridentTopology();
    	
    	RandomFeatureSpout spout=new RandomFeatureSpout();
    	
    	TridentState clusterModel = topology.newStream("training", spout).
				each(new Fields("label", "x0", "x1", "x2"),
						new InstanceCreator<Integer>(),
						new Fields("instance")).
				partitionPersist(new MemoryMapState.Factory(),
						new Fields("instance"),
						new ClusterUpdater("kmeans", new KMeans(3)));
    	
    	topology.newDRPCStream("predict", drpc).
				each(new Fields("args"), new DRPCArgsToInstance(),
						new Fields("instance"))
				.stateQuery(clusterModel, new Fields("instance"),
						new ClusterQuery("kmeans"), new Fields("predict"));
    	
    	return topology.build();
    }
}
