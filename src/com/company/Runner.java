package com.company;

public class Runner extends Thread {

    Runner nextRunner;

    public Runner(String name) {
        this.setName(name);
        this.nextRunner = nextRunner;
    }
    public Runner(String name,Runner nextRunner){
        this.setName(name);
        this.nextRunner = nextRunner;

    }

    public void run(){
        try {
            sleep(1000);
        } catch (InterruptedException e) {

        }
        nextRunner.start();
        if( nextRunner != null){

            System.out.println(this.getName() + " " + "берет палочку");

            System.out.println(this.getName() + " передает палочку " + nextRunner.getName());
        }
        if(nextRunner != null){
            try{
                nextRunner.join();
                this.sleep(3000);
                System.out.println(nextRunner.getName() + " " + "берет палочку");

                System.out.println(nextRunner.getName() + "передает палочку" + this.getName());
            }catch (Exception e){

            }
        } else
            System.out.println(this.getName() + "берет палочку");
    }
}
