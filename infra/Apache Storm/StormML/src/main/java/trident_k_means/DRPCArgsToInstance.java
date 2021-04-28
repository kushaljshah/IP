package trident_k_means;

import java.util.ArrayList;
import java.util.List;

import backtype.storm.tuple.Values;

import com.github.pmerienne.trident.ml.core.Instance;

import storm.trident.operation.BaseFunction;
import storm.trident.operation.TridentCollector;
import storm.trident.tuple.TridentTuple;

public class DRPCArgsToInstance extends BaseFunction{

	private static final long serialVersionUID = 1L;

	public void execute(TridentTuple tuple, TridentCollector collector) {
		// TODO Auto-generated method stub
		String drpc_args = tuple.getString(0);
		String[] args = drpc_args.split(",");
		Integer label=Integer.parseInt(args[0]);
		double[] features=new double[args.length-1];
		for(int i=1; i < args.length; ++i)
		{
			double feature=Double.parseDouble(args[i]);
			features[i-1] = feature;
		}
		Instance<Integer> instance=new Instance<Integer>(label, features);
		
		collector.emit(new Values(instance));
	}

}
