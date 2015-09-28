package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleIAndII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseScheduleIAndII cs = new CourseScheduleIAndII();
		int numCourses = 2;
		int[][] prerequisites = {{1,0}};
		int[] ret = cs.findOrder(numCourses, prerequisites);
		System.out.println(Arrays.toString(ret));
	}

	// BFS, TopoSort
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List[] graph = new ArrayList[numCourses];
		int[] degree = new int[numCourses];
		Queue queue = new LinkedList();
		int count = 0;

		for (int i = 0; i < numCourses; i++)
			graph[i] = new ArrayList();

		for (int i = 0; i < prerequisites.length; i++) {
			degree[prerequisites[i][1]]++;
			graph[prerequisites[i][0]].add(prerequisites[i][1]);
		}
		for (int i = 0; i < degree.length; i++) {
			if (degree[i] == 0) {
				queue.add(i);
				count++;
			}
		}

		while (queue.size() != 0) {
			int course = (int) queue.poll();
			for (int i = 0; i < graph[course].size(); i++) {
				int pointer = (int) graph[course].get(i);
				degree[pointer]--;
				if (degree[pointer] == 0) {
					queue.add(pointer);
					count++;
				}
			}
		}
		if (count == numCourses)
			return true;
		else
			return false;
	}

	// DFS
	public boolean canFinish2(int numCourses, int[][] prerequisites) {
		List[] graph = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++)
			graph[i] = new ArrayList();

		boolean[] visited = new boolean[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			graph[prerequisites[i][1]].add(prerequisites[i][0]);
		}

		for (int i = 0; i < numCourses; i++) {
			if (!dfs(graph, visited, i))
				return false;
		}
		return true;
	}

	private boolean dfs(List[] graph, boolean[] visited, int course) {
		if (visited[course])
			return false;
		else
			visited[course] = true;
		;

		for (int i = 0; i < graph[course].size(); i++) {
			if (!dfs(graph, visited, (int) graph[course].get(i)))
				return false;
		}
		visited[course] = false;
		return true;
	}
	
	
	
	private int N = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        Course[] courses = new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Course(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            courses[prerequisites[i][0]].add(courses[prerequisites[i][1]]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(courses[i], result)) {
                return new int[0];
            }
        }
        return result;
    }

    private boolean isCyclic(Course cur, int[] result) {
        if (cur.tested) return false;
        if (cur.visited) return true;
        cur.visited = true;
        for (Course c : cur.pre) {
            if (isCyclic(c, result)) {
                return true;
            }
        }
        cur.visited = false;
        cur.tested = true;
        result[N++] = cur.number;
        return false;
    }
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] inDegree = new int[numCourses];
        Course[] courses = new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Course(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            courses[prerequisites[i][1]].add(courses[prerequisites[i][0]]);
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        //if queue is empty at all, it means it must have a cycle
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            result[N++] = tmp;
            for(Course c: courses[tmp].pre){
                inDegree[c.number]--;
                if(inDegree[c.number] == 0){
                    queue.offer(c.number);
                }
            }
        }
        return N==numCourses?result:new int[0];
    }
    class Course {
        boolean visited = false;
        boolean tested = false;
        int number;
        List<Course> pre = new ArrayList<Course>();
        public Course(int i) {
            number = i;
        }
        public void add(Course c) {
            pre.add(c);
        }
        public String toString(){
        	return  "Course " + number;
        }
    }
}
