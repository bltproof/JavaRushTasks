package com.javarush.task.task32.task3208;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI-2
*/
public class Solution {
    public static Registry registry;

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.speak();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    // Pretend we're starting an RMI server as the SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            //напишите тут ваш код
            Remote catStub;
            Remote dogStub;

            try {
                Animal cat = new Cat("Loris");
                Animal dog = new Dog("Boris");
                registry = LocateRegistry.createRegistry(2099);
                catStub = UnicastRemoteObject.exportObject(cat, 0);
                dogStub = UnicastRemoteObject.exportObject(dog, 0);

                registry.bind("cat.dog", catStub);
                registry.bind("dog.cat", dogStub);

            } catch (RemoteException | AlreadyBoundException e) {
                System.err.println(e);
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        // Starting an RMI server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        // Start the client
        CLIENT_THREAD.start();
    }
}