package johnny.dsa.alg;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LoadBalancer {
    List<Integer> list; // server id
    Map<Integer, Integer> map; // <server id, index id in list>
    //Random random;
    public LoadBalancer() {
        list = new LinkedList<>();
        map = new HashMap<>();
        //random = new Random();
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        if (map.containsKey(server_id)) {
            return;
        }
        list.add(server_id);
        map.put(server_id, list.size() - 1);
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        int index = map.get(server_id);
        if (index != list.size() - 1) {
            int serverid = list.get(list.size() - 1);
            list.set(index, serverid);
            map.put(serverid, index);
        }
        map.remove(server_id);
        list.remove(list.size() - 1);
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
