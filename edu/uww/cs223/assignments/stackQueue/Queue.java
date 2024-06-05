package edu.uww.cs223.assignments.stackQueue;



public class Queue {
    final int MAX_SIZE = 5;
    int queue_size = 0;
    int front = 0;
    int rear = 0;
    String[] queue = new String[MAX_SIZE];

    public static void main(String[] args) {
        Queue queue = new Queue();
        System.out.println("Queue Contents                           Front  Rear  Size");
        queue.printQueue(queue.queue);
        try {
            queue.ENQUEUE("Heywood");
            queue.printQueue(queue.queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            queue.printQueue(queue.queue);
        }
        try {
            queue.DEQUEUE();
            queue.printQueue(queue.queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            queue.printQueue(queue.queue);
        }
        try {
            queue.ENQUEUE("Kaminski");
            queue.printQueue(queue.queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            queue.printQueue(queue.queue);
        }
        try {
            queue.ENQUEUE("Hunter");
            queue.printQueue(queue.queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            queue.printQueue(queue.queue);
        }
        try {
            queue.ENQUEUE("Frank");
            queue.printQueue(queue.queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            queue.printQueue(queue.queue);
        }
        try {
            queue.ENQUEUE("Dave");
            queue.printQueue(queue.queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            queue.printQueue(queue.queue);
        }
        try {
            queue.ENQUEUE("Hal");
            queue.printQueue(queue.queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            queue.printQueue(queue.queue);
        }
        try {
            queue.ENQUEUE("Heywood");
            queue.printQueue(queue.queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            queue.printQueue(queue.queue);
        }
        try {
            queue.DEQUEUE();
            queue.printQueue(queue.queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            queue.printQueue(queue.queue);
        }
        try {
            queue.DEQUEUE();
            queue.printQueue(queue.queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            queue.printQueue(queue.queue);
        }try {
            queue.DEQUEUE();
            queue.printQueue(queue.queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            queue.printQueue(queue.queue);
        }try {
            queue.ENQUEUE("Heywood");
            queue.printQueue(queue.queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            queue.printQueue(queue.queue);
        }try {
            queue.ENQUEUE("Chandra");
            queue.printQueue(queue.queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            queue.printQueue(queue.queue);
        }try {
            queue.DEQUEUE();
            queue.printQueue(queue.queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            queue.printQueue(queue.queue);
        }try {
            queue.DEQUEUE();
            queue.printQueue(queue.queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            queue.printQueue(queue.queue);
        }try {
            queue.DEQUEUE();
            queue.printQueue(queue.queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            queue.printQueue(queue.queue);
        }try {
            queue.DEQUEUE();
            queue.printQueue(queue.queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            queue.printQueue(queue.queue);
        }try {
            queue.DEQUEUE();
            queue.printQueue(queue.queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            queue.printQueue(queue.queue);
        }
        try {
            queue.ENQUEUE("Frank");
            queue.printQueue(queue.queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            queue.printQueue(queue.queue);
        }
    }

    public void printQueue(String[] queue) {
        String stringQueue = "[";
        if (front > rear || (front == rear && queue_size != 0)) {
            for (int i = front; i < MAX_SIZE; i++) {
                stringQueue += queue[i];
                if (i != MAX_SIZE - 1 || rear != 0) {
                    stringQueue += ", ";
                }
            }
            for (int i = 0; i < rear; i++) {
                stringQueue += queue[i];
                if (i != rear - 1) {
                    stringQueue += ", ";
                }
            }
        } 
        else {
            for (int i = front; i < rear; i++) {
                stringQueue += queue[i];
                if (i != rear - 1) {
                    stringQueue += ", ";
                }
            }
        }
        stringQueue += "]";
        System.out.printf("%-40s %-6s %-5s %-5s%n", stringQueue, front, rear, SIZE());
    }

    public void ENQUEUE(String value) throws Exception {
        if (queue_size == MAX_SIZE) {
            throw new Exception("Cannot Enqueue because Queue is full");
        } else {
            queue[rear++] = value;
            queue_size++;
            if (rear == MAX_SIZE) {
                rear = 0;
            }
        }
    }

    public String DEQUEUE() throws Exception {
        if (queue_size == 0) {
            throw new Exception("Cannot Dequeue because Queue is empty");
        } else {
            String value = queue[front++];
            queue_size--;
            if (front == MAX_SIZE) {
                front = 0;
            }
            return value;
        }
    }

    public String PEEK() throws Exception {
        if (queue_size == 0) {
            throw new Exception("Cannot Peek because Queue is empty");
        } else {
            return queue[front];
        }
    }

    public int SIZE() {
        return queue_size;
    }
}