import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MainClass
{
    public static void main(String[] args)
    {
        LFUCache lfuCache = new LFUCache(4);

        String noValue = lfuCache.checkCache("a");//empty cache test
        if(noValue == null) { System.out.println("checkCache for a");}

        lfuCache.insertInCache("a", "1");//add 1st k,v to cache test

        if(lfuCache.checkCache("a").equals("1"))
        { System.out.println("checkCache for a");}//check recently added k,v test

        lfuCache.insertInCache("b", "2");//add 2nd k,v to cache test
        lfuCache.printCacheState();

        if(lfuCache.checkCache("b").equals("2"))
        { System.out.println("checkCache for b");}//check recently added k,v test

        lfuCache.insertInCache("c", "3");//add
        lfuCache.printCacheState();

        lfuCache.insertInCache("d", "4");//add
        lfuCache.printCacheState();

        if(lfuCache.checkCache("a").equals("1"))
        { System.out.println("checkCache for a");}//check for k=a again

        lfuCache.insertInCache("e", "5");//full cache, check evict mechanism test
        lfuCache.printCacheState();

    }

}
