
public class MainClass
{
    public static void main(String[] args)
    {
        FIFOCache fifoCache = new FIFOCache(4);

        String noValue = fifoCache.checkCache("a");//empty cache test
        if(noValue == null) { System.out.println("checkCache for a");}

        fifoCache.insertInCache("a", "1");//add 1st k,v to cache test

        if(fifoCache.checkCache("a").equals("1"))
        { System.out.println("checkCache for a");}//check recently added k,v test

        fifoCache.insertInCache("b", "2");//add 2nd k,v to cache test
        fifoCache.printCacheState();

        if(fifoCache.checkCache("b").equals("2"))
        { System.out.println("checkCache for b");}//check recently added k,v test

        fifoCache.insertInCache("c", "3");//add
        fifoCache.printCacheState();

        fifoCache.insertInCache("d", "4");//add
        fifoCache.printCacheState();

        if(fifoCache.checkCache("a").equals("1"))
        { System.out.println("checkCache for a");}//check for k=a again
        fifoCache.printCacheState();

        fifoCache.insertInCache("e", "5");//full cache, check evict mechanism test
        fifoCache.printCacheState();
    }

}
