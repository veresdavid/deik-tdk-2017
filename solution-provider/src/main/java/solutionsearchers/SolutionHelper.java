package solutionsearchers;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.Node;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SolutionHelper {
	
	public static String writeSolutions(List<Node> nodes, List<OperatorInterface> operators){
		StringBuilder builder = new StringBuilder();
		for(Node node : nodes){
			LinkedList<Node> tmpNodes = new LinkedList<>();
			
			while(node != null){
				tmpNodes.addFirst(node);
				node = node.getParent();
			}
			
			for(Node tmpNode : tmpNodes){
				if(tmpNode.getParent() != null){
					builder.append(tmpNode.getParent().getId() + "-OP" + operators.indexOf(tmpNode.getOperator()) + "-" + tmpNode.getId() + " ");
				}
			}
			builder.setLength(builder.length() - 1);
			builder.append("\n");
		}
		builder.setLength(builder.length() - 1);
		return builder.toString();
	}
	
	public static String writeOutputForGraphic(Class<?> solutionSearcher, List<Node> nodes, List<Node> treeNodes, List<Node> solutions, String steps, List<OperatorInterface> operators){
		File outputFolder = new File("/srv/tomcat-persistent/graph/solutionOutputs");
		File output = new File("/srv/tomcat-persistent/graph/solutionOutputs/" + solutionSearcher.getSimpleName() + LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd-hh-mm-ss")) + UUID.randomUUID().toString() + ".txt");
		if(!outputFolder.exists())
			outputFolder.mkdirs();
			
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(output.getAbsolutePath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		class StateWithId{
			private StateInterface state;
			private int id;
			
			public StateWithId(StateInterface state, int id){
				this.state = state;
				this.id = id;
			}

			/*public StateInterface getState() {
				return state;
			}

			public void setState(StateInterface state) {
				this.state = state;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}*/

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + id;
				result = prime * result + ((state == null) ? 0 : state.hashCode());
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				StateWithId other = (StateWithId) obj;
				if (id != other.id)
					return false;
				if (state == null) {
					if (other.state != null)
						return false;
				} else if (!state.equals(other.state))
					return false;
				return true;
			}

			@Override
			public String toString() {
				return id + "|" + state;
			}
		}
		
		
		try {
			writer.write("info\n");
			writer.write(solutionSearcher.getSimpleName() + "\n");
			
			Set<StateWithId> uniqueStatesWithId = new HashSet<>();
			for(Node node : nodes){
				uniqueStatesWithId.add(new StateWithId(node.getState(), node.getId()));
			}
			
			writer.write("nodes\n");
			for(StateWithId stateWithId : uniqueStatesWithId){
				writer.write(stateWithId.toString() + "\n");
			}
			
			for(Node node : treeNodes){
				writer.write(node.getId() + "|" + node.getState() + "\n");
			}
			
			writer.write("operators\n");
			for(int i = 0; i < operators.size(); i++){
				writer.write("OP" + i + "|" + operators.get(i) + "\n");
			}

			writer.write("connections\n");
			for(Node node : nodes){
				if(node.getParent() != null){
					writer.write(node.getParent().getId() + "|" + node.getId() + "|" + "OP" + operators.indexOf(node.getOperator()) + "\n");
				}
			}
			for(Node node : treeNodes){
				if(node.getParent() != null){
					writer.write(node.getParent().getId() + "|" + node.getId() + "|" + "OP" + operators.indexOf(node.getOperator()) + "\n");
				}
			}
			
			writer.write("steps\n");
			writer.write(steps + "\n");
			
			writer.write("solutions\n");
			writer.write(writeSolutions(solutions, operators));

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output.getAbsolutePath();
	}
	
	public static int getNodeId(StateInterface state, int maxId, List<Node> reachedNodes){
		
		for(Node reachedNode : reachedNodes){
			if(reachedNode.getState().equals(state)){
				return reachedNode.getId();
			}
		}
		return maxId + 1;
	}
}
