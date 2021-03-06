
public class Util {
	public static void pause(int time){
		try {
		    Thread.sleep(time);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}


	public static void printTitle(){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
				"................................................................................................................................\n" +
				"..........H...H......OO......RRRR.....SSSSS....EEEEE..............................................-#@#-.........................\n" +	
				"..........H...H.....O..O.....R..RR....SS..S....EE..................................................WWWWW*-......................\n" +
				"..........HHHHH....O....O....RRR:......SS......EEEEE............................................*@WWWWW=........................\n" +	
				"..........H...H.....O..O.....R..R........SS....EE............................................:@WWWWWW@-............-+-..........\n" +
				"..........H...H......OO......R...R.....SSSS....EEEEE.......................................#WWWWWWW@WWW#:-...:+-+**#WW@:........\n" +	
				".........................................................................................*WWWWWW@+...*WWWWWW#WWWWWWWWWWW:.......\n" +
				".........................................................................................#WWWW@:......-:#@WWWWWWWWWWWWWWWW-.....\n" +
				".....RRRR......A.......CCCCC....II...N....N.....GGGGG.....................................#WWWWWW#....+#@W@WWWWWWWWWWWWWWWW#....\n" +
				".....R..RR....A.A......CC.......II...N N..N.....G.......................................:#..:#WWWWWWW@WW#@WWWWWWW@*--:=WWWWW@-..\n" +
				".....RRR.....A...A.....C........II...N..N.N.....G..GG..........................-:+++++=W@WWWWWWWWWWWWWWWWWWWWWWW@...-**:..#@@-..\n" +
				".....R..R....AAAAA.....CC.......II...N...NN.....G...G......................:@WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW*................\n" +
				".....R...R...A...A.....CCCCC....II...N....N..... GGGG.........-#WWWW@:-:*@WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW:.................\n" +
				"............................................................:@WWWWWWWW#-:WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW+..................\n" +
				"...........................................................-@WWWWWWWW@-.#WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW=...................\n" +
				"........................................................-:#WWWWW+.-.....-WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW=....................\n" +
				"........................................................:::.-.............=WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW#-.....................\n" +
				".............................................................................-=WWWWW=..............:WWW@........................\n" +
				"..............................................................................@W@@@-...............-WWW=........................\n" +
				"...........................................................................-#W@W#:.................:WWW-........................\n" +
				"...........................................................................#WW@W@=-................+W@+.........................\n" +
				".............................................................................:@@@=@W+..............*@+..........................\n" +
				"................................................................................:@W#:#W#.........*W@#...........................\n" +
				"..................................................................................-@W+@W.......*W@.@=...........................\n" +
				".................................................................................-WW#.=@.....WW*..:W*...........................\n" +
				"..................................................................................=@.........@:....*W*..........................\n" +
				"...................................................................................................-WWW:........................\n" 
		);
	}

}