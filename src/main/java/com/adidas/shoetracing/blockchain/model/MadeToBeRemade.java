package com.adidas.shoetracing.blockchain.model;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.8.7.
 */
@SuppressWarnings("rawtypes")
public class MadeToBeRemade extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506040516106003803806106008339818101604052606081101561003357600080fd5b810190808051604051939291908464010000000082111561005357600080fd5b90830190602082018581111561006857600080fd5b825164010000000081118282018810171561008257600080fd5b82525081516020918201929091019080838360005b838110156100af578181015183820152602001610097565b50505050905090810190601f1680156100dc5780820380516001836020036101000a031916815260200191505b50604052602001805160405193929190846401000000008211156100ff57600080fd5b90830190602082018581111561011457600080fd5b825164010000000081118282018810171561012e57600080fd5b82525081516020918201929091019080838360005b8381101561015b578181015183820152602001610143565b50505050905090810190601f1680156101885780820380516001836020036101000a031916815260200191505b50604052602001805160405193929190846401000000008211156101ab57600080fd5b9083019060208201858111156101c057600080fd5b82516401000000008111828201881017156101da57600080fd5b82525081516020918201929091019080838360005b838110156102075781810151838201526020016101ef565b50505050905090810190601f1680156102345780820380516001836020036101000a031916815260200191505b506040525050835161024e9150600190602086019061027f565b50815161026290600290602085019061027f565b50805161027690600390602084019061027f565b50505050610320565b828054600181600116156101000203166002900490600052602060002090601f0160209004810192826102b557600085556102fb565b82601f106102ce57805160ff19168380011785556102fb565b828001600101855582156102fb579182015b828111156102fb5782518255916020019190600101906102e0565b5061030792915061030b565b5090565b5b80821115610307576000815560010161030c565b6102d18061032f6000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80631a092541146100515780635d1ca631146100ce578063cd112941146100d6578063d52edbc9146100de575b600080fd5b6100596100e6565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561009357818101518382015260200161007b565b50505050905090810190601f1680156100c05780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b61005961017c565b6100596101dd565b61005961023d565b60038054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156101725780601f1061014757610100808354040283529160200191610172565b820191906000526020600020905b81548152906001019060200180831161015557829003601f168201915b5050505050905090565b60008054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156101725780601f1061014757610100808354040283529160200191610172565b60018054604080516020601f600260001961010087891615020190951694909404938401819004810282018101909252828152606093909290918301828280156101725780601f1061014757610100808354040283529160200191610172565b60028054604080516020601f60001961010060018716150201909416859004938401819004810282018101909252828152606093909290918301828280156101725780601f106101475761010080835404028352916020019161017256fea264697066735822122058487f1c92d07ead6e74c6cb00dcb0c35605b9142aacf7bebb992e7e9c5bc69464736f6c63430007060033";

    public static final String FUNC_GETDESCRIPTION = "getDescription";

    public static final String FUNC_GETID = "getId";

    public static final String FUNC_GETOWNERADRESSING = "getOwnerAdressing";

    public static final String FUNC_GETPICTUREURL = "getPictureUrl";

    @Deprecated
    protected MadeToBeRemade(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MadeToBeRemade(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MadeToBeRemade(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MadeToBeRemade(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> getDescription() {
        final Function function = new Function(FUNC_GETDESCRIPTION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getId() {
        final Function function = new Function(FUNC_GETID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getOwnerAdressing() {
        final Function function = new Function(FUNC_GETOWNERADRESSING, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getPictureUrl() {
        final Function function = new Function(FUNC_GETPICTUREURL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static MadeToBeRemade load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MadeToBeRemade(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MadeToBeRemade load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MadeToBeRemade(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MadeToBeRemade load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MadeToBeRemade(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MadeToBeRemade load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MadeToBeRemade(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MadeToBeRemade> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String pictureUrl1, String ownerAdressing1, String description1) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(pictureUrl1), 
                new org.web3j.abi.datatypes.Utf8String(ownerAdressing1), 
                new org.web3j.abi.datatypes.Utf8String(description1)));
        return deployRemoteCall(MadeToBeRemade.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<MadeToBeRemade> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String pictureUrl1, String ownerAdressing1, String description1) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(pictureUrl1), 
                new org.web3j.abi.datatypes.Utf8String(ownerAdressing1), 
                new org.web3j.abi.datatypes.Utf8String(description1)));
        return deployRemoteCall(MadeToBeRemade.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MadeToBeRemade> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String pictureUrl1, String ownerAdressing1, String description1) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(pictureUrl1), 
                new org.web3j.abi.datatypes.Utf8String(ownerAdressing1), 
                new org.web3j.abi.datatypes.Utf8String(description1)));
        return deployRemoteCall(MadeToBeRemade.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MadeToBeRemade> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String pictureUrl1, String ownerAdressing1, String description1) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(pictureUrl1), 
                new org.web3j.abi.datatypes.Utf8String(ownerAdressing1), 
                new org.web3j.abi.datatypes.Utf8String(description1)));
        return deployRemoteCall(MadeToBeRemade.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
