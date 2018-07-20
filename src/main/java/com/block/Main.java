package com.block;


import com.block.web3j.Web3;

public class Main {


    public static void main(String[] args) {

        Web3.getInstance().getWeb3ClientVersion();
        Web3.getInstance().ethGetBalance();
        Web3.getInstance().shutdown();

//      Web3.getInstance().ethGetBalance();
//      System.out.println(Web3.getInstance().loadCredentials().getAddress());
     /* Sample_sol_Sample.deploy(Web3.getInstance().web3j(),Web3.getInstance().loadCredentials(),
              DefaultGasProvider.GAS_PRICE,DefaultGasProvider.GAS_LIMIT).
              observable().subscribe(new Subscriber<Sample_sol_Sample>() {
          @Override
          public void onCompleted() {
              System.out.println("onCompleted");
          }

          @Override
          public void onError(Throwable throwable) {
              System.out.println("onError "+throwable.getMessage());
          }

          @Override
          public void onNext(Sample_sol_Sample sample_sol_sample) {
              System.out.println("onNext "+sample_sol_sample.getContractAddress());
          }
      });*/
    }
}
