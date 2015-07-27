package ool.com.odl.orchestrator.client.opendaylight;

import java.util.List;

public final class OpenFlowTopologyData {

	private static String masterTopology = new String();
	private static String currentTopology = new String();

	public static String getMasterTopology() {
		return masterTopology;
	}

	public static void setMasterTopology(String masterTopology) {
		OpenFlowTopologyData.masterTopology = masterTopology;
	}

	public static String getCurrentTopology() {
		return currentTopology;
	}

	public static void setCurrentTopology(String currentTopology) {
		OpenFlowTopologyData.currentTopology = currentTopology;
	}
	
	public List<EdgeProperties> edgeProperties;
	
	public class EdgeProperties {
		private Edge edge;
		private Properties properties;
		public Edge getEdge() {
			return edge;
		}
		public void setEdge(Edge edge) {
			this.edge = edge;
		}
		public Properties getProperties() {
			return properties;
		}
		public void setProperties(Properties properties) {
			this.properties = properties;
		} 
	}
	
	public class Edge {
		private NodeConnector tailNodeConnector;
		private NodeConnector headNodeConnector;
		public NodeConnector getTailNodeConnector() {
			return tailNodeConnector;
		}
		public void setTailNodeConnector(NodeConnector tailNodeConnector) {
			this.tailNodeConnector = tailNodeConnector;
		}
		public NodeConnector getHeadNodeConnector() {
			return headNodeConnector;
		}
		public void setHeadNodeConnector(NodeConnector headNodeConnector) {
			this.headNodeConnector = headNodeConnector;
		}
	}
	
	public class Properties {
		private TimeStamp timeStamp;

		public TimeStamp getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(TimeStamp timeStamp) {
			this.timeStamp = timeStamp;
		}
	}
	
	public class TimeStamp {
		private String value;
		private String name;
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
	
	public class NodeConnector {
		private String id;
		private String type;
		private Node node;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Node getNode() {
			return node;
		}
		public void setNode(Node node) {
			this.node = node;
		}
	}
	
	public class Node {
		private String id;
		private String type;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
	}

	public List<EdgeProperties> getEdgeProperties() {
		return edgeProperties;
	}

	public void setEdgeProperties(List<EdgeProperties> edgeProperties) {
		this.edgeProperties = edgeProperties;
	}
}
