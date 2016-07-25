import java.awt.Adjustable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Graph {
	
	private Map<Integer, Map<Integer, Integer>> adjacencylist;
	
	public Graph(int totalNodes) {
		adjacencylist = new HashMap<>();
		
		for (int i = 0; i < totalNodes; i++) {
			adjacencylist.put(i, new HashMap<>());
		}
	}
	
	public void setEdge(int source, int destination, int weight) {
		Map<Integer, Integer> slist = adjacencylist.get(source);
		slist.put(destination, weight);
	}
	
	public Map<Integer, Integer> getEdge(int source) {
		if(source > adjacencylist.size()) {
			System.err.println("The vertex entered is not valid");
			return null;
		}
		//System.out.println("List-->"+ adjacencylist.get(source).keySet());
		return adjacencylist.get(source);
	}
	
	public Set<Integer> getDestination(int source) {
		return adjacencylist.get(source).keySet();
	}
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("graph.txt"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int totalNodes = Integer.parseInt(st.nextToken());
		int totalEdges = Integer.parseInt(st.nextToken());
		
		int source, destination, weight;
		
		Graph graph = new Graph(totalNodes);
		
		
		
		for (int i = 0; i < totalEdges; i++) {
			st = new StringTokenizer(br.readLine());
			source = Integer.parseInt(st.nextToken());
			destination = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			
			graph.setEdge(source, destination, weight);

		}
		
		/*for (int i = 0; i < totalNodes; i++) {
			System.out.print(i+"-->");
			Map<Integer, Integer> edgeList = graph.getEdge(i);
			int k = 1;
			Set <Integer> dest = graph.getDestination(i);
			for (Integer j : dest) {
				if(k < dest.size()) {
					System.out.print("["+j+","+edgeList.get(j)+"]->");
					k++;
				} else {
					System.out.print("["+j+","+edgeList.get(j)+"]");
					
				}
			}
			System.out.println();
		}*/
		
		File file = new File("mod.txt");
		
		if(!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter fw = new FileWriter(file.getAbsolutePath());
		BufferedWriter bw = new BufferedWriter(fw);
		List<Integer> edgeInfo = new LinkedList();
		List<Integer> weightList = new LinkedList();
		
		int p = 0;
		int m = 0;
		edgeInfo.add(0);
		p++;
		for (int i = 0; i < totalNodes; i++) {
			int n = graph.getDestination(i).size();
			if(n == 0) {
				edgeInfo.add(0);
				p++;
			} else {
				m = m+n;
				edgeInfo.add(m);
				p++;
			}
		}
		
		bw.write(p + " " + totalEdges + "\n");
		
		int l = 0;
		for (Integer numberofedge : edgeInfo) {
			if(l<edgeInfo.size()) {
				bw.write(numberofedge + " ");
				l++;
			} else {
				bw.write(""+numberofedge);
			}
			
		}
		bw.write("\n");
		
		for (int i = 0; i < totalNodes; i++) {
			Map<Integer, Integer> edgeList = graph.getEdge(i);
			int k = 1;
			Set <Integer> dest = graph.getDestination(i);
			for (Integer j : dest) {
				if(k < dest.size()) {
					bw.write(j+" ");
					weightList.add(edgeList.get(j));
					k++;
				} else {
					bw.write(""+j);
					weightList.add(edgeList.get(j));
					
				}
			}
			bw.write("\n");
		}
		int k = 0;
		for (Integer weightDestination : weightList) {
			if(k<weightList.size()) {
				bw.write(weightDestination + " ");
				k++;
			} else {
				bw.write(""+weightDestination);
			}
			
		}
		bw.close();
		
		
		
		
		
		
	}
	
}
