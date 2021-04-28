My Notes:
https://drive.google.com/file/d/1w_fjGzr3SYTanL11_LRZ6W7M3Az5KQMK/view?usp=sharing

https://storm.apache.org/releases/current/Tutorial.html

https://www.freecodecamp.org/news/apache-storm-is-awesome-this-is-why-you-should-be-using-it-d7c37519a427/

https://www.simplilearn.com/introduction-to-storm-tutorial-video

https://www.tutorialspoint.com/apache_storm/index.htm

https://www.michael-noll.com/tutorials/running-multi-node-storm-cluster/




Storm Architecture
https://www.simplilearn.com/ice9/free_resources_article_thumb/apache-storm-architecture.JPG


Storm Processes
A Zookeeper cluster is used for coordinating the master, supervisor and worker processes. Moving on, let us explore the Nimbus process.

Nimbus Process

Nimbus is the master daemon of Storm cluster.

Runs on only one node called the master node

Assigns and distributes the tasks to the worker nodes

Monitors the tasks

Reassigns tasks on node failure.

Supervisor Process

The supervisor is the worker daemon of Storm cluster.

Runs on each worker node of the cluster

Runs each task as a separate process called worker process

Communicates with Nimbus daemon using zookeeper

Number of worker processes for each task can be configured

Worker Process

Worker process does the actual work of Storm.

Runs on any worker node of the cluster

Started and monitored by the supervisory process

Runs either spout or bolt tasks

Number of worker processes for each task can be configured