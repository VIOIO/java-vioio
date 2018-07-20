import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class Web3 {

    private static Web3 instance = null;
    private static String TAG = Web3.class.getSimpleName();
    private Web3j web3j;

    private Web3() {
//0x42a9f7a4df9ef052f8199125a9f30fc396ffa286
    }

    public static Web3 getInstance() {
        if (instance == null) {
            instance = new Web3();
            instance.init();
        }
        return instance;
    }

    private void init() {
        if (web3j == null) {
            web3j = Web3j.build(new HttpService(API.TEST_INFURA));
        }
    }

    public Web3j web3j() {
        nullPointerException(web3j);
        return web3j;
    }

    public String getWeb3ClientVersion() {
        nullPointerException(web3j);
        Web3ClientVersion web3ClientVersion = null;
        try {
            web3ClientVersion = web3j.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            System.out.println(TAG + " getWeb3ClientVersion : " + clientVersion);
            return clientVersion;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Credentials loadCredentials() {
        try {
            return WalletUtils.loadCredentials(API.KEY, API.KEYSTORE + API.KEYSTORE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String ethGetBalance() {
        nullPointerException(web3j);
        EthGetBalance balance = null;
        try {
            balance = web3j.ethGetBalance(loadCredentials().getAddress(), DefaultBlockParameter.valueOf("latest")).send();
            String blanceETH = Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER).toPlainString().concat(" ether");
            System.out.println(TAG + " ethGetBalance : " + blanceETH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void generateNewWalletFile() {
        nullPointerException(web3j);
        String fileName = null;
        try {
            fileName = WalletUtils.generateNewWalletFile(API.KEY, new File(API.KEYSTORE), false);
            Credentials credentials = WalletUtils.loadCredentials(API.KEY, API.KEYSTORE + "/" + fileName);
            System.out.println(TAG + " generateNewWalletFile : " + credentials.getAddress());
            System.out.println(TAG + " generateNewWalletFile : " + fileName);
        } catch (CipherException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }

    }

    public void shutdown() {
        nullPointerException(web3j);
        web3j.shutdown();
    }

    public <T> void nullPointerException(T o) {
        if (o == null) {
            throw new NullPointerException();
        }
    }


}
