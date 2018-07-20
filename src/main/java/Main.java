import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.ipc.UnixIpcService;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;
import rx.Subscriber;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;

import static org.web3j.tx.Transfer.GAS_LIMIT;
import static org.web3j.tx.gas.DefaultGasProvider.GAS_PRICE;

public class Main {


    public static void main(String[] args) {
        System.out.println(new File("Sample.sol").getAbsolutePath());

        Web3.getInstance().getWeb3ClientVersion();
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
