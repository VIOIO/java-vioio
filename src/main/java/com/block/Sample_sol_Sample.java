package com.block;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class Sample_sol_Sample extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a03191633179055610123806100326000396000f30060806040526004361060525763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166360fe47b1811460575780636d4ce63c14606e5780638da5cb5b146092575b600080fd5b348015606257600080fd5b50606c60043560cd565b005b348015607957600080fd5b50608060d5565b60408051918252519081900360200190f35b348015609d57600080fd5b5060a460db565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b600302600155565b60015490565b60005473ffffffffffffffffffffffffffffffffffffffff16815600a165627a7a723058203937cceb9c59a92e8a8307a88067b49ab5b5f3f2e0e0e5d2acaab1797eb05bb40029";

    public static final String FUNC_SET = "set";

    public static final String FUNC_GET = "get";

    public static final String FUNC_OWNER = "owner";

    protected Sample_sol_Sample(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Sample_sol_Sample(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> set(BigInteger x) {
        final Function function = new Function(
                FUNC_SET, 
                Arrays.<Type>asList(new Uint256(x)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> get() {
        final Function function = new Function(FUNC_GET, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static RemoteCall<Sample_sol_Sample> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Sample_sol_Sample.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Sample_sol_Sample> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Sample_sol_Sample.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Sample_sol_Sample load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Sample_sol_Sample(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Sample_sol_Sample load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Sample_sol_Sample(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
