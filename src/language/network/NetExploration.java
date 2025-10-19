package language.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetExploration {

    public static void main(String[] args) {

        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address);

            InetAddress address1 = InetAddress.getByName("www.google.com");
            System.out.println(address1);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }
}
