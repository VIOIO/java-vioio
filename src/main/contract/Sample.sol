pragma solidity ^0.4.23;

contract Sample {

    address public owner;
    constructor() public{
        owner = msg.sender;
    }

    uint storedData;

    function set(uint x) public {
        storedData = x * 3;
    }

    function get() public view returns (uint) {
        return storedData;
    }

}
