****All The Codes are in Peer2Peer/Src folder in runnable Condition****

****P2P Lab — Peer-to-Peer Chat Application****

Welcome to the P2P Lab!
This project demonstrates a simple Peer-to-Peer chatting application built in Java. The application evolves through 4 phases, adding features and complexity in each step.

****Project Structure****

Phase1_Peer.java — Basic one-time message send/receive on the same machine.

Phase2_Peer.java — Send multiple messages until typing exit, on the same machine.

Phase3_PeerA.java & Phase3_PeerB.java — Two peers chatting on the same machine using different ports.

Phase4_PeerA.java & Phase4_PeerB.java — Two peers chatting between two different machines on the same network.

****How to Run Each Phase****


****Phase 1: Single Message Exchange (Same Machine)****

Run Phase1_Peer.java.

The program listens on port 5000 for one incoming message, then sends a single message to itself.

It prints the received message.

****Phase 2: Continuous Messaging Until Exit (Same Machine)****

Run Phase2_Peer.java.

The program listens on port 5001 and can receive multiple messages.

You can type and send multiple messages until you type exit to quit.

****Phase 3: Chatting Between Two Peers on the Same Machine****

Run Phase3_PeerA.java and Phase3_PeerB.java on the same machine (two separate programs).

PeerA listens on port 6000, PeerB listens on port 6001.

You can chat back and forth by typing messages in each program’s console.

Type exit to quit.

****Phase 4: Chatting Between Two Different Machines on the Same Network****

Run Phase4_PeerA.java on the first machine (e.g., IP: 192.168.70.109).

Run Phase4_PeerB.java on the second machine (e.g., IP: 192.168.70.110).

Each peer listens on a dedicated port (6000 for PeerA, 6001 for PeerB).

Make sure both machines are connected to the same network.

Add firewall rules to allow inbound/outbound traffic on these ports.

You can now chat across machines.

Type exit to quit.
