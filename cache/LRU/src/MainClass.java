
import java.util.concurrent.ConcurrentLinkedDeque;

public class MainClass
{
    public static void main(String[] args)
    {
        LRUCache lruCache = new LRUCache(4);

        String noValue = lruCache.checkCache("a");//empty cache test
        if(noValue == null) { System.out.println("checkCache for a");}

        lruCache.insertInCache("a", "1");//add 1st k,v to cache test

        if(lruCache.checkCache("a").equals("1"))
        { System.out.println("checkCache for a");}//check recently added k,v test

        lruCache.insertInCache("b", "2");//add 2nd k,v to cache test
        lruCache.printCacheState();

        if(lruCache.checkCache("b").equals("2"))
        { System.out.println("checkCache for b");}//check recently added k,v test

        lruCache.insertInCache("c", "3");//add
        lruCache.printCacheState();

        lruCache.insertInCache("d", "4");//add
        lruCache.printCacheState();

        if(lruCache.checkCache("a").equals("1"))
        { System.out.println("checkCache for a");}//check for k=a again
        lruCache.printCacheState();

        lruCache.insertInCache("e", "5");//full cache, check evict mechanism test
        lruCache.printCacheState();

    }

    public static void printList(ConcurrentLinkedDeque<Integer> a)
    {
        for(Integer i : a)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
