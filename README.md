# javaInterview
Store all my notes for java interviews

## Polymorphism
The ability of one method to have different behavior depending on the type of object it is being called on.



## Parallelism

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
