package trident_k_means;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.github.pmerienne.trident.ml.core.Instance;
import com.github.pmerienne.trident.ml.testing.data.Datasets;

import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Fields;
import storm.trident.operation.TridentCollector;
import storm.trident.spout.IBatchSpout;

public class RandomFeatureSpout implements IBatchSpout{

	private int batchSize=10;
	private int numFeatures=3;
	private int numClasses=3;
	
	public void open(Map conf, TopologyContext context) {
		// TODO Auto-generated method stub
		
	}

	public void emitBatch(long batchId, TridentCollector collector) {
		// TODO Auto-generated method stub
		List<Instance<Integer>> data = Datasets.
				generateDataForMultiLabelClassification(batchSize, numFeatures, numClasses);
		
		
		for(Instance<Integer> instance : data)
		{
			List<Object> values=new ArrayList<Object>();
			values.add(instance.label);
			
			for(double feature : instance.getFeatures())
			{
				values.add(feature);
			}
			collector.emit(values);
		}
		
	}

	public void ack(long batchId) {
		// TODO Auto-generated method stub
		
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public Map getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	public Fields getOutputFields() {
		// TODO Auto-generated method stub
		return new Fields("label", "x0", "x1", "x2");
	}

}
