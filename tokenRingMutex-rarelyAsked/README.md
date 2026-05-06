## PS 5 - Run Instructions

### Prerequisites
- Java JDK 8+ installed and `java`/`javac` available in PATH.

### Compile
From the PS 5 folder:

```
javac TokenRingMutex.java
```

### Run
Start one process per node in the ring. Each process needs:

```
java TokenRingMutex <myPort> <nextHost> <nextPort> <hasToken>
```

Example with 3 nodes on localhost:

Terminal 1:
```
java TokenRingMutex 5001 localhost 5002 true
```

Terminal 2:
```
java TokenRingMutex 5002 localhost 5003 false
```

Terminal 3:
```
java TokenRingMutex 5003 localhost 5001 false
```

Only one node should start with `hasToken` set to `true` and it should start at last.
