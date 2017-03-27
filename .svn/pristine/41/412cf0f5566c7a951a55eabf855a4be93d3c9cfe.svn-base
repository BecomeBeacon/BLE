package com.example.changsu.bluetoothle;

/***
 *  소켓 통신을 위한 패킷 정의 (Android <-> PC Server)
 *   - Command ID, Device Address, Major, Minor 값 전송
 *
 *
 */

public class BleSocketPacket {
    public final static int COMMAND_NONE = 0x0;
    public final static int COMMAND_REQUEST = 0x01;     // Request (Android -> Server)
    public final static int COMMAND_RESPONSE = 0x02;    // Response (Server -> Android)
    public final static String HEADER_NAME = "bleproj";

    String mHeaderName = HEADER_NAME;
    int mPacketLength;
    int mCommandId;
    String mDeviceAddr;
    int mMajor;
    int mMinor;

    public BleSocketPacket()
    {
        mHeaderName = HEADER_NAME;
        mPacketLength = 0;
        mCommandId = COMMAND_NONE;
        mDeviceAddr = "";
        mMajor = 0;
        mMinor = 0;


    }

    public BleSocketPacket(int cmd, String devAddr, int major, int minor, String serviceLink)
    {
        mCommandId = cmd;
        mDeviceAddr = devAddr;
        mMajor = major;
        mMinor = minor;

    }

    /*
        Request Message 생성
        +------------+-------------+-------+-------+
        + Command ID | Dev Address | Major | Minor |
        +------------+-------------+-------+-------+
     */

    public String makeRequestMsg(String devAddr, int major, int minor)
    {
        BleSocketPacket packet = new BleSocketPacket(COMMAND_REQUEST, devAddr, major, minor, "");
        String msg = String.valueOf(COMMAND_REQUEST) + ";" + devAddr + ";" +
                String.valueOf(major) + ";" + String.valueOf(minor);

        int length = msg.length();
        return msg;
    }

    /*
        수신된 message를 parsing해서 string[]에 저장하고 리턴함

     */
    public String[] parseResponseMsg(String msg)
    {
        String arrayString[];

        arrayString = msg.split(";");

        return arrayString;
    }

}
