package com.mic.java8.lambda;

@FunctionalInterface
interface OnClick {

    void onClick();

    String toString();

}


public class  FunctionalDemo{

    public static void main(String[] args) {
          FunctionalDemo demo = new FunctionalDemo();
          demo.onClick(()-> {
                  System.out.println("click");});

          OnClick onClick =()->{
              System.out.println("hello");
          };

        System.out.println(onClick.getClass());
        System.out.println(onClick.getClass().getSuperclass());
        System.out.println(onClick.getClass().getInterfaces());
    }

    public void onClick(OnClick click){
        click.onClick();
    }
}
