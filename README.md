💬 Java Peer-to-Peer Chat System
This Java project lets two peers chat with each other using sockets, in a step-by-step way — starting from simple messages on the same PC to full messaging between two computers on a local network.

Built for understanding P2P architecture, message sending, socket handling, and port communication.

🎯 What You’ll Need
Java (JDK 8 or above)

NetBeans IDE (Recommended)

🛠 Phases (Project Versions)
The lab is organized into 4 progressive phases, each adding more capability:

🔹 Phase 1: One-Time Message on Same PC
📄 File: Phase1_Peer.java

Run the program.

It opens a socket on localhost:5000.

Sends a single message and receives it back.

Useful to test initial setup and socket communication.

✅ Goal: Understand basic socket creation and message flow.

🔸 Phase 2: Continuous Messaging (Same PC)
📄 File: Phase2_Peer.java

Run the code — it listens on port 5001.

Type messages and send them one by one.

Type exit to stop.

Shows how to keep a socket running to handle multiple messages.

✅ Goal: Enable ongoing messaging using Java sockets.

🖥️ Phase 3: Chat Between Two Peers on One PC
📄 Files:

Phase3_PeerA.java

Phase3_PeerB.java

Peer A listens on port 6000, Peer B on 6001.

Run both in separate terminal windows (or NetBeans tabs).

Type and send messages in both directions.

✅ Goal: Build a two-way chat between two programs using different ports.

🌐 Phase 4: Chat Between Two Devices (LAN)
📄 Files:

Phase4_PeerA.java (on your PC)

Phase4_PeerB.java (on your classmate’s PC)

🖧 Requirements:

Both PCs must be on the same Wi-Fi or LAN

Use each other's IP address and port

👣 Steps:
On Computer A (e.g., 192.168.70.109):

Run Phase4_PeerA.java

It listens on port 6000

On Computer B (e.g., 192.168.70.110):

Run Phase4_PeerB.java

It sends to IP 192.168.70.109, port 6000

💡 Find your IP:

On Windows: ipconfig

On Mac/Linux: ifconfig or ip a

✅ Goal: Real-time chat between two users across machines.
