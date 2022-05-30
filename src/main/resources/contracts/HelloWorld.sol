pragma solidity ^0.7.6;

// SPDX-License-Identifier: MIT
contract HelloWorld {

    string message;
    //  address private _owner;

    constructor(string memory msg) {
        message = msg;
        //  _owner = 0x0000000000000000000000000000000000000000;
    }

    function changeMessage(string memory newMessage) public {//onlyOwner {
        message = newMessage;
    }

    function getMessage() public view returns (string memory) {
        return message;
    }

    /*
    modifier onlyOwner() {
        require(_owner == msg.sender, "Ownable: caller is not the owner");
        _;
    }*/
}
