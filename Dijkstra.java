import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {
	private PriorityQueue<TableN> pQueue;
	private Graph graphObj;
	private TableN tableArray[];
	double dis = 0;
	ArrayList<Vertix> Path = new ArrayList<>();

	public void makeTable(Vertix start, Graph graphObj) {
		this.graphObj = graphObj;
		pQueue = new PriorityQueue<TableN>();
		// table size same as number of vertix
		tableArray = new TableN[graphObj.getNumberOfVertix()];
		TableN temptable;
		for (int i = 0; i < graphObj.getNumberOfVertix(); i++) {
			// ضفت الفيرتكس على التيبل
			temptable = new TableN(graphObj.getVertixArray()[i]);
			tableArray[i] = new TableN(graphObj.getVertixArray()[i]);
			if (temptable.getVertix().getName().equals(start.getName())) {
				temptable.setDistance(0);
				tableArray[i].setDistance(0);
				pQueue.add(temptable);
			} else {
				temptable.setDistance(Integer.MAX_VALUE);
				tableArray[i].setDistance(Integer.MAX_VALUE);
			}
			temptable.setKnown(false);
			tableArray[i].setKnown(false);
			temptable.setPrevVertix(new Vertix(0, "0", 0, 0));
			tableArray[i].setPrevVertix(new Vertix(0, "0", 0, 0));
		}
	}

	public void findMinUnknownDistance(Vertix s, Vertix d) {
		while (!pQueue.isEmpty()) {
			int srIndex = pQueue.poll().getVertix().getIndex();
			tableArray[srIndex].setKnown(true);
			// اذا السورس هو نفسه الديستنشن ف بريك
			if (d.getName().compareToIgnoreCase(tableArray[srIndex].getVertix().getName()) == 0) {
				break;
			}
			// بلف ع الادجيسنت تبعون الفيرتكس
			for (int i = 0; i < graphObj.getAdj()[srIndex].size(); i++) {
				// 
				int desIndex = graphObj.getAdj()[srIndex].get(i).getTarget().getIndex();
				// unknown vertix
				if (!tableArray[desIndex].isKnown()) {
					// TO find minimum Distance
					if (tableArray[srIndex].getDistance()
							+ graphObj.getAdj()[srIndex].get(i).getWeight() < tableArray[desIndex].getDistance()) {

						tableArray[desIndex].setDistance(
								tableArray[srIndex].getDistance() + graphObj.getAdj()[srIndex].get(i).getWeight());
						System.out.println("+++++++" + tableArray[srIndex].getDistance()
								+ graphObj.getAdj()[srIndex].get(i).getWeight());

						System.out.println("}}}" + tableArray[desIndex].getDistance());

						// to put prev vertix
						tableArray[desIndex].setPrevVertix(tableArray[srIndex].getVertix());
						pQueue.add(tableArray[desIndex]);
					}

				}
			}

		}
		// 
		dis = tableArray[d.getIndex()].getDistance();

	}

	public void printPath(Vertix v) {
		// return to add null nestead of 0
		System.out.println("DIKK!!!!");
		System.out.println(tableArray[v.getIndex()].getPrevVertix().getName());
		if (tableArray[v.getIndex()].getPrevVertix().getName().compareTo("0") != 0) {
			System.out.println("DIKKKK");
			Path.add(v);
			printPath(tableArray[v.getIndex()].getPrevVertix());
		}

	}

}
