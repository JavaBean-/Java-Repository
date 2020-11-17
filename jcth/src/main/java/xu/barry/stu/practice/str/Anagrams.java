package xu.barry.stu.practice.str;

import org.junit.Test;

import java.util.*;

public class Anagrams {
    @Test
    public void test() {
        String[] b = new String[]{"abc", "bcs"};
        System.out.println(groupAnagrams(b));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> result = new  ArrayList<>();
        List<Byte[]> collections = new ArrayList<>();
        //获取组合字符key
        for (String str : strs) {
            byte[] a = str.getBytes();
            Byte[] wapper =  WrapperByte(a);
            Arrays.sort(wapper, Comparator.naturalOrder());
            Optional<Byte[]> optional = collections.stream().filter(chars -> compare(chars, wapper)).findFirst();
            if(optional.orElse(null) != null) continue;
            collections.add(wapper);
        }
        //转化为HashMap
        HashMap<String, ArrayList<String>> store = new HashMap();
        collections.stream()
                .forEach(bytes -> {
                    byte[] key = UnWrapperByte(bytes);
                    String keys = new String(key);
                    store.put(keys,new ArrayList<>());
                });

        //遍历归类
        for(String str : strs){
            Byte[] wrapperByte = WrapperByte(str.getBytes());
            Arrays.sort(wrapperByte, Comparator.naturalOrder());
            String keys = new String(UnWrapperByte(wrapperByte));
            store.get(keys).add(str);
        }

        //获得结果
        for(Object key : store.keySet()){
            ArrayList<String> list =  store.get(key);
            result.add(list);
        }
        return result;
    }

    private Byte[] WrapperByte(byte[] a) {
        Byte[] wrapper = new  Byte[a.length];
        for(int i = 0 ; i < a.length ; i ++){
            wrapper[i] = a[i];
        }
        return wrapper;
    }

    private byte[] UnWrapperByte(Byte[] a) {
        byte[] wrapper = new byte[a.length];
        for(int i = 0 ; i < a.length ; i ++){
            wrapper[i] = a[i];
        }
        return wrapper;
    }

    private boolean compare(Byte[] m, Byte[] n) {
        if (m.length != n.length) return false;
        Arrays.sort(m, Comparator.naturalOrder());
        Arrays.sort(n, Comparator.naturalOrder());
        for (int i = 0; i<m.length;  i++){
                if(m[i] != n[i])
                    return false;
        }
        return  true;
    }
}
