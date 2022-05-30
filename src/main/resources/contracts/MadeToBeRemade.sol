pragma solidity ^0.7.6;

contract MadeToBeRemade {

    string id;
    string pictureUrl;
    string ownerAdressing;
    string description;

    constructor(string memory pictureUrl1, string memory ownerAdressing1, string memory description1) {
        pictureUrl = pictureUrl1;
        ownerAdressing = ownerAdressing1;
        description = description1;
    }

    function getId() public view returns (string memory) {
        return id;
    }

    function getPictureUrl() public view returns (string memory) {
        return pictureUrl;
    }

    function getOwnerAdressing() public view returns (string memory) {
        return ownerAdressing;
    }

    function getDescription() public view returns (string memory) {
        return description;
    }
}
