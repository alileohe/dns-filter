package fixture.dns.wiredata;

import java.net.InetAddress;
import java.net.UnknownHostException;

import dk.mada.dns.lookup.Query;
import dk.mada.dns.wire.model.DnsName;
import dk.mada.dns.wire.model.DnsRecords;
import dk.mada.dns.wire.model.DnsReplies;
import dk.mada.dns.wire.model.DnsReply;
import dk.mada.dns.wire.model.DnsRequests;

public class TestQueries {

	// dig @localhost -p 8053 +nocookie +noadflag +nodnssec jp.dk
	/* Query jp.dk, id:0x4f65, flags:0x0100 (Q,query,,,rd,,,,OK)
	* 0x0000 4f 65 01 00 00 01 00 00  00 00 00 01|02 6a 70 02 Oe...........jp.
	* 0x0010 64 6b 00 00 01 00 01 00  00 29 10 00 00 00 00 00 dk.......)......
	* 0x0020 00 00                                           ..
	 */
	public static byte[] JP_DK = new byte[] {0x4f, 0x65, 0x01, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x02, 0x6a, 0x70, 0x02, 0x64, 0x6b, 0x00, 0x00, 0x01, 0x00, 0x01, 0x00, 0x00, 0x29, 0x10, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, };

	// dig @localhost -p 8053 +nocookie +noadflag +nodnssec AAAA mozilla.org
	/* Request for mozilla.org
	* 0x0000 e4 ba 01 00 00 01 00 00  00 00 00 01 07 6d 6f 7a .............moz
	* 0x0010 69 6c 6c 61 03 6f 72 67  00 00 1c 00 01 00 00 29 illa.org.......)
	* 0x0020 10 00 00 00 00 00 00 00                         ........
	 */
	public static byte[] MOZILLA_ORG_AAAA = new byte[] {(byte)0xe4, (byte)0xba, 0x01, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x07, 0x6d, 0x6f, 0x7a, 0x69, 0x6c, 0x6c, 0x61, 0x03, 0x6f, 0x72, 0x67, 0x00, 0x00, 0x1c, 0x00, 0x01, 0x00, 0x00, 0x29, 0x10, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, };

	/* Reply for mozilla.org
	* 0x0000 e4 ba 81 80 00 01 00 00  00 01 00 01 07 6d 6f 7a .............moz
	* 0x0010 69 6c 6c 61 03 6f 72 67  00 00 1c 00 01 c0 0c 00 illa.org........
	* 0x0020 06 00 01 00 00 0a b8 00  4f 09 69 6e 66 6f 62 6c ........O.infobl
	* 0x0030 6f 78 31 07 70 72 69 76  61 74 65 04 6d 64 63 32 ox1.private.mdc2
	* 0x0040 07 6d 6f 7a 69 6c 6c 61  03 63 6f 6d 00 09 73 79 .mozilla.com..sy
	* 0x0050 73 61 64 6d 69 6e 73 07  6d 6f 7a 69 6c 6c 61 03 sadmins.mozilla.
	* 0x0060 6f 72 67 00 78 58 1c d5  00 00 00 b4 00 00 00 b4 org.xX..........
	* 0x0070 00 12 75 00 00 00 00 3c  00 00 29 05 ac 00 00 00 ..u....<..).....
	* 0x0080 00 00 00                                        ...
	* 
	* ; (2 servers found)
	* ;; global options: +cmd
	* ;; Got answer:
	* ;; ->>HEADER<<- opcode: QUERY, status: NOERROR, id: 58554
	* ;; flags: qr rd ra; QUERY: 1, ANSWER: 0, AUTHORITY: 1, ADDITIONAL: 1
	* ;; WARNING: Message has 381 extra bytes at end
	* 
	* ;; OPT PSEUDOSECTION:
	* ; EDNS: version: 0, flags:; udp: 1452
	* ;; QUESTION SECTION:
	* ;mozilla.org.			IN	AAAA
	* 
	* ;; AUTHORITY SECTION:
	* mozilla.org.		2744	IN	SOA	infoblox1.private.mdc2.mozilla.com. sysadmins.mozilla.org. 2019040469 180 180 1209600 60
	*/
	public static byte[] MOZILLA_ORG_AAAA_REPLY = new byte[] {(byte)0xe4, (byte)0xba, (byte)0x81, (byte)0x80, 0x00, 0x01, 0x00, 0x00, 0x00, 0x01, 0x00, 0x01, 0x07, 0x6d, 0x6f, 0x7a, 0x69, 0x6c, 0x6c, 0x61, 0x03, 0x6f, 0x72, 0x67, 0x00, 0x00, 0x1c, 0x00, 0x01, (byte)0xc0, 0x0c, 0x00, 0x06, 0x00, 0x01, 0x00, 0x00, 0x0a, (byte)0xb8, 0x00, 0x4f, 0x09, 0x69, 0x6e, 0x66, 0x6f, 0x62, 0x6c, 0x6f, 0x78, 0x31, 0x07, 0x70, 0x72, 0x69, 0x76, 0x61, 0x74, 0x65, 0x04, 0x6d, 0x64, 0x63, 0x32, 0x07, 0x6d, 0x6f, 0x7a, 0x69, 0x6c, 0x6c, 0x61, 0x03, 0x63, 0x6f, 0x6d, 0x00, 0x09, 0x73, 0x79, 0x73, 0x61, 0x64, 0x6d, 0x69, 0x6e, 0x73, 0x07, 0x6d, 0x6f, 0x7a, 0x69, 0x6c, 0x6c, 0x61, 0x03, 0x6f, 0x72, 0x67, 0x00, 0x78, 0x58, 0x1c, (byte)0xd5, 0x00, 0x00, 0x00, (byte)0xb4, 0x00, 0x00, 0x00, (byte)0xb4, 0x00, 0x12, 0x75, 0x00, 0x00, 0x00, 0x00, 0x3c, 0x00, 0x00, 0x29, 0x05, (byte)0xac, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, };

	// dig @localhost -p 8053 +nocookie +noadflag +nodnssec googleadservices.com
	/* Query googleadservices.com, id:0x0f52, flags:0x0100 (Q,query,,,rd,,,,OK)
	* 0x0000 0f 52 01 00 00 01 00 00  00 00 00 01|10 67 6f 6f .R...........goo
	* 0x0010 67 6c 65 61 64 73 65 72  76 69 63 65 73 03 63 6f gleadservices.co
	* 0x0020 6d 00 00 01 00 01 00 00  29 10 00 00 00 00 00 00 m.......).......
	* 0x0030 00                                              .
	 */
	public static byte[] GOOGLEADSERVICES_COM = new byte[] {0x0f, 0x52, 0x01, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x10, 0x67, 0x6f, 0x6f, 0x67, 0x6c, 0x65, 0x61, 0x64, 0x73, 0x65, 0x72, 0x76, 0x69, 0x63, 0x65, 0x73, 0x03, 0x63, 0x6f, 0x6d, 0x00, 0x00, 0x01, 0x00, 0x01, 0x00, 0x00, 0x29, 0x10, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, };

	// dig @localhost -p 8053 +nocookie +noadflag +nodnssec acdn.adnxs.com
	/* Request for acdn.adnxs.com
	* 0x0000 ad 84 01 00 00 01 00 00  00 00 00 01 04 61 63 64 .............acd
	* 0x0010 6e 05 61 64 6e 78 73 03  63 6f 6d 00 00 01 00 01 n.adnxs.com.....
	* 0x0020 00 00 29 10 00 00 00 00  00 00 00                ..)........
	 */
	public static byte[] ADNXS_COM = new byte[] {(byte)0xad, (byte)0x84, 0x01, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x04, 0x61, 0x63, 0x64, 0x6e, 0x05, 0x61, 0x64, 0x6e, 0x78, 0x73, 0x03, 0x63, 0x6f, 0x6d, 0x00, 0x00, 0x01, 0x00, 0x01, 0x00, 0x00, 0x29, 0x10, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, };

	/* Reply for acdn.adnxs.com
	* 0x0000 ad 84 81 80 00 01 00 02  00 00 00 01 04 61 63 64 .............acd
	* 0x0010 6e 05 61 64 6e 78 73 03  63 6f 6d 00 00 01 00 01 n.adnxs.com.....
	* 0x0020 c0 0c 00 05 00 01 00 00  02 47 00 1e 04 70 72 6f .........G...pro
	* 0x0030 64 08 61 70 70 6e 65 78  75 73 03 6d 61 70 06 66 d.appnexus.map.f
	* 0x0040 61 73 74 6c 79 03 6e 65  74 00 c0 2c 00 01 00 01 astly.net..,....
	* 0x0050 00 00 00 08 00 04 c7 e8  29 6c 00 00 29 05 ac 00 ........)l..)...
	* 0x0060 00 00 00 00 00                                  .....
	* 
	* ;; global options: +cmd
	* ;; Got answer:
	* ;; ->>HEADER<<- opcode: QUERY, status: NOERROR, id: 44420
	* ;; flags: qr rd ra; QUERY: 1, ANSWER: 2, AUTHORITY: 0, ADDITIONAL: 1
	* ;; WARNING: Message has 411 extra bytes at end
	* 
	* ;; OPT PSEUDOSECTION:
	* ; EDNS: version: 0, flags:; udp: 1452
	* ;; QUESTION SECTION:
	* ;acdn.adnxs.com.			IN	A
	* 
	* ;; ANSWER SECTION:
	* acdn.adnxs.com.		583	IN	CNAME	prod.appnexus.map.fastly.net.
	* prod.appnexus.map.fastly.net. 8	IN	A	199.232.41.108
	*/
	public static byte[] ADNXS_COM_REPLY = new byte[] {(byte)0xad, (byte)0x84, (byte)0x81, (byte)0x80, 0x00, 0x01, 0x00, 0x02, 0x00, 0x00, 0x00, 0x01, 0x04, 0x61, 0x63, 0x64, 0x6e, 0x05, 0x61, 0x64, 0x6e, 0x78, 0x73, 0x03, 0x63, 0x6f, 0x6d, 0x00, 0x00, 0x01, 0x00, 0x01, (byte)0xc0, 0x0c, 0x00, 0x05, 0x00, 0x01, 0x00, 0x00, 0x02, 0x47, 0x00, 0x1e, 0x04, 0x70, 0x72, 0x6f, 0x64, 0x08, 0x61, 0x70, 0x70, 0x6e, 0x65, 0x78, 0x75, 0x73, 0x03, 0x6d, 0x61, 0x70, 0x06, 0x66, 0x61, 0x73, 0x74, 0x6c, 0x79, 0x03, 0x6e, 0x65, 0x74, 0x00, (byte)0xc0, 0x2c, 0x00, 0x01, 0x00, 0x01, 0x00, 0x00, 0x00, 0x08, 0x00, 0x04, (byte)0xc7, (byte)0xe8, 0x29, 0x6c, 0x00, 0x00, 0x29, 0x05, (byte)0xac, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, };


	// dig @localhost -p 8053 +nocookie +noadflag +nodnssec imgs.xkcd.com
	/* Request for imgs.xkcd.com
	* 0x0000 9c 22 01 00 00 01 00 00  00 00 00 01 04 69 6d 67 ."...........img
	* 0x0010 73 04 78 6b 63 64 03 63  6f 6d 00 00 01 00 01 00 s.xkcd.com......
	* 0x0020 00 29 10 00 00 00 00 00  00 00                   .)........
	* 
	* OPT section is:
	* 00  00 29  10 00  00 00 00 00   00 00
	* NAME
	*     Type (OPT)
	*            Class (requestor's payload size)
	*                   Flags
	*                                 RData size
	*/
	public static final byte[] IMGS_XKCD_COM = new byte[] {(byte)0x9c, 0x22, 0x01, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x04, 0x69, 0x6d, 0x67, 0x73, 0x04, 0x78, 0x6b, 0x63, 0x64, 0x03, 0x63, 0x6f, 0x6d, 0x00, 0x00, 0x01, 0x00, 0x01, 0x00, 0x00, 0x29, 0x10, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, };

	/* Reply for imgs.xkcd.com
	* 0x0000 9c 22 81 80 00 01 00 02  00 00 00 01 04 69 6d 67 ."...........img
	* 0x0010 73 04 78 6b 63 64 03 63  6f 6d 00 00 01 00 01 c0 s.xkcd.com......
	* 0x0020 0c 00 05 00 01 00 00 02  ad 00 23 09 64 75 61 6c ..........#.dual
	* 0x0030 73 74 61 63 6b 01 69 03  73 73 6c 06 67 6c 6f 62 stack.i.ssl.glob
	* 0x0040 61 6c 06 66 61 73 74 6c  79 03 6e 65 74 00 c0 2b al.fastly.net..+
	* 0x0050 00 01 00 01 00 00 00 08  00 04 c7 e8 28 43 00 00 ............(C..
	* 0x0060 29 05 ac 00 00 00 00 00  00                      )........
	* 
	* ; (2 servers found)
	* ;; global options: +cmd
	* ;; Got answer:
	* ;; ->>HEADER<<- opcode: QUERY, status: NOERROR, id: 39970
	* ;; flags: qr rd ra; QUERY: 1, ANSWER: 2, AUTHORITY: 0, ADDITIONAL: 1
	* 
	* ;; OPT PSEUDOSECTION:
	* ; EDNS: version: 0, flags:; udp: 1452
	* ;; QUESTION SECTION:
	* ;imgs.xkcd.com.			IN	A
	* 
	* ;; ANSWER SECTION:
	* imgs.xkcd.com.		685	IN	CNAME	dualstack.i.ssl.global.fastly.net.
	* dualstack.i.ssl.global.fastly.net. 8 IN	A	199.232.40.67
	* 
	* OPT section is:
	* 00  00 29  05 ac  00 00 00 00   00 00
	* NAME
	*     Type (OPT)
	*            Class (requestor's payload size)
	*                   Flags
	*                                 RData size
	*/
	public static final byte[] IMGS_XKCD_COM_REPLY = new byte[] {(byte)0x9c, 0x22, (byte)0x81, (byte)0x80, 0x00, 0x01, 0x00, 0x02, 0x00, 0x00, 0x00, 0x01, 0x04, 0x69, 0x6d, 0x67, 0x73, 0x04, 0x78, 0x6b, 0x63, 0x64, 0x03, 0x63, 0x6f, 0x6d, 0x00, 0x00, 0x01, 0x00, 0x01, (byte)0xc0, 0x0c, 0x00, 0x05, 0x00, 0x01, 0x00, 0x00, 0x02, (byte)0xad, 0x00, 0x23, 0x09, 0x64, 0x75, 0x61, 0x6c, 0x73, 0x74, 0x61, 0x63, 0x6b, 0x01, 0x69, 0x03, 0x73, 0x73, 0x6c, 0x06, 0x67, 0x6c, 0x6f, 0x62, 0x61, 0x6c, 0x06, 0x66, 0x61, 0x73, 0x74, 0x6c, 0x79, 0x03, 0x6e, 0x65, 0x74, 0x00, (byte)0xc0, 0x2b, 0x00, 0x01, 0x00, 0x01, 0x00, 0x00, 0x00, 0x08, 0x00, 0x04, (byte)0xc7, (byte)0xe8, 0x28, 0x43, 0x00, 0x00, 0x29, 0x05, (byte)0xac, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, };
	
	
	/* Query detectportal.firefox.com, id:0x9cc9, flags:0x0100 (Q,query,,,rd,,,,OK)                                                                                                                                    
	* 0x0000 9c c9 01 00 00 01 00 00  00 00 00 01|0c 64 65 74 .............det                                                                                                                                         
	* 0x0010 65 63 74 70 6f 72 74 61  6c 07 66 69 72 65 66 6f ectportal.firefo                               
	* 0x0020 78 03 63 6f 6d 00 00 01  00 01 00 00 29 10 00 00 x.com.......)...                                                                                                                                         
	* 0x0030 00 00 00 00 00                                  .....                                                                                                                                                     
	 */                                                                                                                                                                                                                
	public static byte[] DETECTPORTAL_FIREFOX_COM = new byte[] {(byte)0x9c, (byte)0xc9, 0x01, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x0c, 0x64, 0x65, 0x74, 0x65, 0x63, 0x74, 0x70, 0x6f, 0x72, 0x74, 0x61, 0x6c, 0x07, 0x66, 0x69, 0x72, 
	0x65, 0x66, 0x6f, 0x78, 0x03, 0x63, 0x6f, 0x6d, 0x00, 0x00, 0x01, 0x00, 0x01, 0x00, 0x00, 0x29, 0x10, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, };                                                                 

	/*
	 * 
	 * Make canned reply for detectportal.firefox.com, based on real reply:
	 * 	 detectportal.firefox.com.       11      IN      CNAME                                                    
	 *   detectportal.prod.mozaws.net.   60      IN      CNAME                                                    
	 *   detectportal.firefox.com-v2.edgesuite.net 9999 IN CNAME
     *   a1089.dscd.akamai.net.  10      IN      A       95.101.142.120                                           
     *   a1089.dscd.akamai.net.  10      IN      A       104.84.152.177
	*/
	public static DnsReply getDetectportalFirefoxChainedReply(Query q) throws UnknownHostException {
		var firefoxCom = DnsName.fromName("detectportal.firefox.com");
		var mozawsNet = DnsName.fromName("detectportal.prod.mozaws.net");
		var akamaiNet = DnsName.fromName("a1089.dscd.akamai.net");
		
		var firefoxC = DnsRecords.cRecordFrom(firefoxCom, mozawsNet,  100);
		var mozawsC = DnsRecords.cRecordFrom(mozawsNet, akamaiNet, 100);
		var akamaiA = DnsRecords.aRecordFrom(akamaiNet, InetAddress.getByName("95.101.142.120"), 100);
		
		return DnsReplies.fromRequestWithAnswers(q.getRequest(), firefoxC, mozawsC, akamaiA);
	}


	// dig @localhost -p 8053 +nocookie +noadflag +nodnssec noscript-csp.invalid
	/* Request for noscript-csp.invalid
	* 0x0000 0e ae 01 00 00 01 00 00  00 00 00 01 0c 6e 6f 73 .............nos
	* 0x0010 63 72 69 70 74 2d 63 73  70 07 69 6e 76 61 6c 69 cript-csp.invali
	* 0x0020 64 00 00 01 00 01 00 00  29 10 00 00 00 00 00 00 d.......).......
	* 0x0030 00                                              .
	 */
	public static final byte[] NOSCRIPT_CSP_INVALID = new byte[] {0x0e, (byte)0xae, 0x01, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x0c, 0x6e, 0x6f, 0x73, 0x63, 0x72, 0x69, 0x70, 0x74, 0x2d, 0x63, 0x73, 0x70, 0x07, 0x69, 0x6e, 0x76, 0x61, 0x6c, 0x69, 0x64, 0x00, 0x00, 0x01, 0x00, 0x01, 0x00, 0x00, 0x29, 0x10, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, };

	/* Dns server reply for noscript-csp.invalid
	* 0x0000 0e ae 85 83 00 01 00 00  00 01 00 02 0c 6e 6f 73 .............nos
	* 0x0010 63 72 69 70 74 2d 63 73  70 07 69 6e 76 61 6c 69 cript-csp.invali
	* 0x0020 64 00 00 01 00 01 c0 0c  00 06 00 01 00 00 2a 30 d.............*0
	* 0x0030 00 1f 06 6e 6f 62 6f 64  79 c0 19 c0 32 00 00 00 ...nobody...2...
	* 0x0040 01 00 00 0e 10 00 00 04  b0 00 09 3a 80 00 00 2a ...........:...*
	* 0x0050 30 0b 65 78 70 6c 61 6e  61 74 69 6f 6e c0 19 00 0.explanation...
	* 0x0060 10 00 01 00 00 2a 30 00  8e 8d 42 6c 6f 63 6b 69 .....*0...Blocki
	* 0x0070 6e 67 20 69 73 20 6d 61  6e 64 61 74 65 64 20 62 ng is mandated b
	* 0x0080 79 20 73 74 61 6e 64 61  72 64 73 2c 20 73 65 65 y standards, see
	* 0x0090 20 72 65 66 65 72 65 6e  63 65 73 20 6f 6e 20 68  references on h
	* 0x00a0 74 74 70 73 3a 2f 2f 77  77 77 2e 69 61 6e 61 2e ttps://www.iana.
	* 0x00b0 6f 72 67 2f 61 73 73 69  67 6e 6d 65 6e 74 73 2f org/assignments/
	* 0x00c0 73 70 65 63 69 61 6c 2d  75 73 65 2d 64 6f 6d 61 special-use-doma
	* 0x00d0 69 6e 2d 6e 61 6d 65 73  2f 73 70 65 63 69 61 6c in-names/special
	* 0x00e0 2d 75 73 65 2d 64 6f 6d  61 69 6e 2d 6e 61 6d 65 -use-domain-name
	* 0x00f0 73 2e 78 68 74 6d 6c 00  00 29 05 ac 00 00 00 00 s.xhtml..)......
	* 0x0100 00 00                                           ..
	 */
	public static final byte[] NOSCRIPT_CSP_INVALID_REPLY = new byte[] {0x0e, (byte)0xae, (byte)0x85, (byte)0x83, 0x00, 0x01, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x0c, 0x6e, 0x6f, 0x73, 0x63, 0x72, 0x69, 0x70, 0x74, 0x2d, 0x63, 0x73, 0x70, 0x07, 0x69, 0x6e, 0x76, 0x61, 0x6c, 0x69, 0x64, 0x00, 0x00, 0x01, 0x00, 0x01, (byte)0xc0, 0x0c, 0x00, 0x06, 0x00, 0x01, 0x00, 0x00, 0x2a, 0x30, 0x00, 0x1f, 0x06, 0x6e, 0x6f, 0x62, 0x6f, 0x64, 0x79, (byte)0xc0, 0x19, (byte)0xc0, 0x32, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x0e, 0x10, 0x00, 0x00, 0x04, (byte)0xb0, 0x00, 0x09, 0x3a, (byte)0x80, 0x00, 0x00, 0x2a, 0x30, 0x0b, 0x65, 0x78, 0x70, 0x6c, 0x61, 0x6e, 0x61, 0x74, 0x69, 0x6f, 0x6e, (byte)0xc0, 0x19, 0x00, 0x10, 0x00, 0x01, 0x00, 0x00, 0x2a, 0x30, 0x00, (byte)0x8e, (byte)0x8d, 0x42, 0x6c, 0x6f, 0x63, 0x6b, 0x69, 0x6e, 0x67, 0x20, 0x69, 0x73, 0x20, 0x6d, 0x61, 0x6e, 0x64, 0x61, 0x74, 0x65, 0x64, 0x20, 0x62, 0x79, 0x20, 0x73, 0x74, 0x61, 0x6e, 0x64, 0x61, 0x72, 0x64, 0x73, 0x2c, 0x20, 0x73, 0x65, 0x65, 0x20, 0x72, 0x65, 0x66, 0x65, 0x72, 0x65, 0x6e, 0x63, 0x65, 0x73, 0x20, 0x6f, 0x6e, 0x20, 0x68, 0x74, 0x74, 0x70, 0x73, 0x3a, 0x2f, 0x2f, 0x77, 0x77, 0x77, 0x2e, 0x69, 0x61, 0x6e, 0x61, 0x2e, 0x6f, 0x72, 0x67, 0x2f, 0x61, 0x73, 0x73, 0x69, 0x67, 0x6e, 0x6d, 0x65, 0x6e, 0x74, 0x73, 0x2f, 0x73, 0x70, 0x65, 0x63, 0x69, 0x61, 0x6c, 0x2d, 0x75, 0x73, 0x65, 0x2d, 0x64, 0x6f, 0x6d, 0x61, 0x69, 0x6e, 0x2d, 0x6e, 0x61, 0x6d, 0x65, 0x73, 0x2f, 0x73, 0x70, 0x65, 0x63, 0x69, 0x61, 0x6c, 0x2d, 0x75, 0x73, 0x65, 0x2d, 0x64, 0x6f, 0x6d, 0x61, 0x69, 0x6e, 0x2d, 0x6e, 0x61, 0x6d, 0x65, 0x73, 0x2e, 0x78, 0x68, 0x74, 0x6d, 0x6c, 0x00, 0x00, 0x29, 0x05, (byte)0xac, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, };


	public static Query makeTestQuery(byte[] data) {
		var req = DnsRequests.fromWireData(data);
		
		var query = new Query(req, "127.0.0.1");
		return query;
	}

}