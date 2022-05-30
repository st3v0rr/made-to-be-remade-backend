package com.adidas.shoetracing.api;

import com.adidas.shoetracing.blockchain.model.MadeToBeRemade;
import com.adidas.shoetracing.model.ShoeInformation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.Web3j;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

@RestController
public class ShoeInformationController implements ShoeInformationApi {

    private final Web3j web3j;
    private final RawTransactionManager transactionManager;
    private final ContractGasProvider contractGasProvider;

    public ShoeInformationController(Web3j web3j, RawTransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        this.web3j = web3j;
        this.transactionManager = transactionManager;
        this.contractGasProvider = contractGasProvider;
    }

    @Override
    public ResponseEntity<ShoeInformation> retrieveMessage(String id) {
        MadeToBeRemade madeToBeRemade = MadeToBeRemade.load(id, web3j, transactionManager, contractGasProvider);
        ShoeInformation shoeInformation = new ShoeInformation();
        try {
            shoeInformation.setDescription(madeToBeRemade.getDescription().send());
            shoeInformation.setOwnerAdressing(madeToBeRemade.getOwnerAdressing().send());
            shoeInformation.setPictureUrl(madeToBeRemade.getPictureUrl().send());
            shoeInformation.setId(madeToBeRemade.getId().send());
        } catch (Exception e) {
            e.printStackTrace();
        };
        return ResponseEntity.ok(shoeInformation);
    }

}
