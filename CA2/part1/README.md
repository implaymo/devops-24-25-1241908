CA2 Part1: Virtualization: Technical Report 

# Introduction

This guide provides detailed instructions on using virtualization techniques with VirtualBox. It covers the process of setting up and configuring a virtual machine, establishing the development environment, and running various projects within the virtualized setup.

By following these steps, you will gain hands-on experience in creating and managing virtual environments, which are essential for modern software development and operations.


## VirtualBox Virtual Machine Setup Guide

### Step 1: Download and Install VirtualBox

The first step is to download VirtualBox from the official website [here](https://www.virtualbox.org/wiki/Downloads) and install it on your system.

### Step 2: Create a New Virtual Machine

Once VirtualBox is installed, you must launch VirtualBox and click on the "New" button to begin setting up a new virtual machine (VM). You must:

- Name the VM.
- Select the appropriate type and version that matches the operating system you intend to install.

### Step 3: Allocate Memory and Create a Virtual Hard Disk

You must allocate enough memory to the virtual machine to ensure smooth operation. After memory allocation, you must create a virtual hard disk to meet the VM’s storage requirements.

### Step 4: Mount the Operating System ISO File

In the VM settings, under the "Storage" section, you must mount the ISO file of the operating system to the virtual CD/DVD drive. This allows the virtual machine to access the installation media for the OS.

### Step 5: Start the VM and Install the OS

After mounting the ISO file, you must start the VM. You will then follow the on-screen instructions to install the operating system.

### Step 6: Install VirtualBox Guest Additions

Once the OS installation is complete, you must install the VirtualBox Guest Additions to improve the integration between the host machine and the virtual machine.

### Step 7: Configure the Virtual Machine for Ubuntu 18.04 Minimal Installation

You must configure the virtual machine settings in preparation for the Ubuntu 18.04 minimal installation. Follow these steps:

1. Connect the VM to the Ubuntu installation media available via the provided minimal CD link.
2. Allocate 2048 MB of RAM to ensure adequate performance.
3. For networking, set Network Adapter 1 to **NAT** to allow internet access.
4. Configure Network Adapter 2 as a **Host-only Adapter (vboxnet0)** to enable isolated communication between the VM and the host machine.

By following these steps, you will successfully configure a virtual machine in VirtualBox with the desired operating system and network settings.

---

## Configuring Network and Essential Services for Virtual Machine

### Step 1: Open VirtualBox Host Network Manager

Once the basic virtual machine setup is completed, you must focus on configuring the network and essential services to enhance the functionality and accessibility of the VM. To begin, you must open the **VirtualBox Host Network Manager** by navigating to the main menu and selecting **File -> Host Network Manager**.

### Step 2: Create a Host-Only Network

You must click the **Create** button, which will add a new Host-only network to the list. This setup will allow you to specify a name for the network within the virtual machine’s network settings.

### Step 3: Configure the Host-Only Adapter

After setting up the **Host-only Adapter**, you must check the IP address range. The default range is **192.168.56.1/24**. You should choose **192.168.56.5** as the IP address for the second adapter of the VM to ensure it falls within the designated subnet.

### Step 4: Update Package Repositories

Upon booting the virtual machine, you must update the package repositories to ensure all software is up to date. Run the following command:

```bash
sudo apt update
```

### Step 5: Install Network Tools
You must install the network tools package to facilitate network configuration. Run the following command to install it:
```bash
sudo apt install net-tools
```

### Step 6: Configure Network Settings
To assign the chosen IP address, you must edit the network configuration file. Use the following command to open it:
```bash
sudo nano /etc/netplan/01-netcfg.yaml
```
You must ensure the file contains the following network configuration settings:

```bash
network:
  version: 2
  renderer: networkd
  ethernets:
    enp0s3:
      dhcp4: yes
    enp0s8:
      addresses:
        - 192.168.56.5/24
```
After editing the configuration file, you must apply the changes with this command:

```bash
sudo netplan apply
```

### Step 7: Install and Configure OpenSSH Server
To remotely manage the VM, you must install and configure the OpenSSH server. First, install it by running:
```bash
sudo apt install openssh-server
```

Next, you must enable password authentication by editing the SSH configuration file. Open it with the following command:
```bash
sudo nano /etc/ssh/sshd_config
```

Uncomment the line PasswordAuthentication yes to enable password-based login. After saving the changes, you must restart the SSH service with the following command:
```bash
sudo service ssh restart
```

### Step 8: Set Up an FTP Server
To enable file transfer to and from the VM, you must set up an FTP server. First, install vsftpd by running:
```bash
sudo apt install vsftpd
```

Then, you must enable write access within the FTP server configuration. Open the configuration file:
```bash
sudo nano /etc/vsftpd.conf
```

Uncomment the line write_enable=YES to allow write access. After saving the changes, restart the FTP service:
```bash
sudo service vsftpd restart
```

By following these steps, the virtual machine will be properly configured with networking, SSH, and FTP services, ensuring enhanced functionality and accessibility.


