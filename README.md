# javaInterview
Store all my notes for java interviews

## Database

### MemCache (NoSQL In-Memory)
 * key-value data store
 * Good for small and static data like HTML code fragments, strings
 * Not good for dynamic data
 * Multi-threaded, LRU for old data
 * 250 bytes key names

### Redis (NoSQL In-Memory)
 * key-value data store, data structure store
 * Single-threaded: can scale horizontally
 * Control 6 data eviction policies
 * 512 MB keys and values
 * 5 data structures
   * lists, sets, sorted sets, hyperloglogs, bitmaps, geospatial indexes
 * Redis Hash to store objects fields and values instead of serialized object
 * Serving layer for data calculated by spark

[Redis vs Memcached] (http://www.infoworld.com/article/3063161/application-development/why-redis-beats-memcached-for-caching.html)

### Auto-Increment
 * AUTO_INCREMENT column must be defined as part of an index
 `
 create table box(
    my_id       int(16) auto_increment,
    toys        varchar(4000),
    PRIMARY KEY (my_id)
  )
  ALTER TABLE box AUTO_INCREMENT=1001;
  insert into box (toys) values("foobar");
  `

## Load-balancer

### Nginx (Web-server)
Proxy server, load balancer, and HTTP cache.
Round-robin, Least-connected, IP-Hash, weighted load-balancing
Has one master process and several worker processes.
Server health checks

## Parallelism

### Java thread-safe
1. Add synchronized to a method
2. Use atomic data types such as AtomicInteger
3. Locking mechanisms

### Threads and processes
Each thread in a process has access to the same memory.
Processes loads and saves registers for each thread.

#### Mutexes and Semaphores
Semaphores support wait and signal operations.
Mutexes support lock and unlock methods.
Each object in Java has its own mutex. Synchronized methods lock the mutex and unlock when methods completes.

#### Deadlock causes
1. Mutual exclusion: Only one process can use the resource at a time.
2. Hold and Wait: A process holds a resource and keeps it while waiting for other resources
3. No preemption: Resource only released voluntarily by its process
4. Circular wait: A process waits for a resource held by another process. And the second process is waiting for the resource held by the first process.

#### Deadlock handling
1. Removing mutual exclusion means no process has exclusive access to a resource
2. Process requests all resources before starting up
3. Release all resources held by a process.
4. Disabling interrupts in critical sections. Requires hierarchy to determine ordering of resources.

## Polymorphism
The ability of one method to have different behavior depending on the type of object it is being called on.
