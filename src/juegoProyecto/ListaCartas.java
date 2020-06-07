package juegoProyecto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observer;
import java.util.Random;

public class ListaCartas {
	private ArrayList<Carta> lCartas;
	public ListaCartas() {
		lCartas = new ArrayList<Carta>();
	}

	public void borrarCarta(Carta pCarta) {
		lCartas.remove(pCarta);
	}
	public void agregarCarta(Carta pCarta) {
		lCartas.add(pCarta);
	}
	public int contarCartas() {
		return lCartas.size();
	}
	public String imprimirCartas() {
		String lista ="";
		for(int ind = 1; ind<=lCartas.size(); ind ++) {
			Carta unaCarta = getCartaEnPos(ind);
			lista =lista + unaCarta.imprimirCarta();
			lista =lista + " ";
		}
		return lista;
	}
	public String imprimirNombres() {
		String lista ="";
		for(int ind = 1; ind<=lCartas.size(); ind ++) {
			Carta unaCarta = getCartaEnPos(ind);
			lista =lista + unaCarta.imprimirNombre();
			lista =lista + " ";
		}
		return lista;
	}
	public Carta eliminarCartaEnPos(int pInd) {
		Carta p = lCartas.remove(pInd-1);
		return p;
	}
	public int size() {
		return lCartas.size();
	}
	public Carta getCartaEnPos(int pPos) {
		return lCartas.get(pPos-1);
	}
	
	//Preguntar duda -- Caso en el que la lista tiene 3 cartas y llamas al metodo add(4,Carta) para a�adirla en la posicion 4. �Daria error?
	public void agregarCartaEnPos(int pInd, Carta pCarta) {
		lCartas.add(pInd-1,pCarta);
	}
	public Carta cogerCartaAlAzar() {
		//metodo para coger una carta al azar
		Random aleat = new Random();
		int size = lCartas.size();
		int pos = aleat.nextInt(size)+1;
		return eliminarCartaEnPos(pos);
	}
	public void eliminarCartaAlAzar() {
		
		Random aleat = new Random();
		int size = lCartas.size();
		int pos = aleat.nextInt(size)+1;
		eliminarCartaEnPos(pos);
	}
	private Iterator<Carta> getIterator(){
		return lCartas.iterator();
	}
	public void vaciar() {
		lCartas = new ArrayList<Carta>();
	}
	public void ordenar() {
		// Este metodo o es necesario aqui de momento
		ArrayList<Carta> auxLista = new ArrayList<Carta>();
		int posicion,ind = 0;
		while(Cola.getCola().size()>0) {
			posicion = posicionMayorFuerza();
			auxLista.add(ind,eliminarCartaEnPos(posicion));
			ind++;
		}
		lCartas = auxLista;
	}
	private int posicionMayorFuerza() {
		Iterator<Carta> iter = getIterator();
		Carta unaCarta;
		int pFuerza = 0;
		int ind = 1;
		int indMax = 0;
		while(iter.hasNext()) {
			unaCarta = iter.next();
			if(unaCarta.getFuerza() > pFuerza) {
				pFuerza = unaCarta.getFuerza();
				indMax = ind;
			}
			ind ++;
		}
		return indMax;
	}

	public int buscarMayorFuerza() {
		// Este metodo o es necesario aqui de momento

		Iterator<Carta> iter = getIterator();
		Carta unaCarta;
		int pFuerza = 0;
		while(iter.hasNext()) {
			unaCarta = iter.next();
			if(unaCarta.getFuerza() > pFuerza) {
				pFuerza = unaCarta.getFuerza();
			}
		}
		return pFuerza;
	}
	 public void barajar()
	 {   // Metodo para barajar la lista de cartas
		 Random aleat = new Random();
		 for(int primera = 1; primera <= lCartas.size(); primera++) {
			 int segunda = aleat.nextInt(lCartas.size()-1)+1; 
			 Carta temp = getCartaEnPos(primera);
			 lCartas.set(primera-1, getCartaEnPos(segunda));
			 lCartas.set(segunda-1,temp);
		 
		 }
	 }
	public void crearBaraja(EnumColor pColor) {
		//A�ade una baraja completa a la lista de cartas
		Carta unaCarta = CartaFactory.getCartaFactory().crearCarta("Camaleon", pColor);
		lCartas.add(unaCarta);
		unaCarta = CartaFactory.getCartaFactory().crearCarta("Canguro", pColor);
		lCartas.add(unaCarta);
		unaCarta = CartaFactory.getCartaFactory().crearCarta("Cocodrilo", pColor);
		lCartas.add(unaCarta);
		unaCarta = CartaFactory.getCartaFactory().crearCarta("Foca", pColor);
		lCartas.add(unaCarta);
		unaCarta = CartaFactory.getCartaFactory().crearCarta("Hipopotamo", pColor);
		lCartas.add(unaCarta);
		unaCarta = CartaFactory.getCartaFactory().crearCarta("Jirafa", pColor);
		lCartas.add(unaCarta);
		unaCarta = CartaFactory.getCartaFactory().crearCarta("Leon", pColor);
		lCartas.add(unaCarta);
		unaCarta = CartaFactory.getCartaFactory().crearCarta("Loro", pColor);
		lCartas.add(unaCarta);
		unaCarta = CartaFactory.getCartaFactory().crearCarta("Mofeta", pColor);
		lCartas.add(unaCarta);
		unaCarta = CartaFactory.getCartaFactory().crearCarta("Mono", pColor);
		lCartas.add(unaCarta);
		unaCarta = CartaFactory.getCartaFactory().crearCarta("Serpiente", pColor);
		lCartas.add(unaCarta);
		unaCarta = CartaFactory.getCartaFactory().crearCarta("Zebra", pColor);
		lCartas.add(unaCarta);
	}
	public int posDeCarta(Carta pUnaCarta) {
		return lCartas.indexOf(pUnaCarta);
	}
	public boolean vacia() {
		if(contarCartas()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public int sumarPuntos() {
		int suma = 0;
		Iterator<Carta> iter = lCartas.iterator();
		while(iter.hasNext()) {
			Carta unaCarta = iter.next();
			suma = suma + unaCarta.getFuerza();
		}
		return suma;
	}

	////////
	public int cartaNumColor(EnumColor pColor,int pFuerza) {
		ArrayList<Integer> l = getApariciones(pFuerza);
		int pos = 0;
		int cant = 0;
		int ind = 1;
		while(ind<=l.size()) {
			pos = l.get(ind);
			if(getCartaEnPos(pos).getColor().equals(pColor)) {
				cant ++;
			}
		}
		return cant;
	}
	public int numCartasMenoresQue(int pFuerza) {
		Iterator<Carta> iter = getIterator();
		Carta unaCarta;
		int cant = 0;
		boolean esta = false;
		while(iter.hasNext() && !esta) {
			unaCarta = iter.next();
			if(unaCarta.getFuerza() < pFuerza) {
				cant ++;
			}
		}
		return cant;
	}
	public void eliminarAparicion(int pNum) {
		Iterator<Carta> iter = getIterator();
		Carta unaCarta;
		int index = 0;
		boolean esta = false;
		while(iter.hasNext() && !esta) {
			unaCarta = iter.next();
			if(unaCarta.getFuerza() == pNum) {
				esta = true;
			}
			index ++;
		}
		//Notificamos el cambio realizado
		if(esta) {
		eliminarCartaEnPos(index);

		}
		Cola.getCola().notificar(); //

	}
	public void eliminarApariciones(int pNum) {
		while(esta(pNum)) {
			eliminarAparicion(pNum);
		}
		//Notificamos el cambio realizado
	}
	public void reiniciarLista() {
		lCartas = new ArrayList<Carta>();
		Cola.getCola().notificar();
		//Notificamos el cambio realizado
	}
	public int posOrden(int pFuerza) {
		//Dada una lista ordenada y una fuerza devuelve la posicion en la que se le a�adiria en la lista
		Iterator<Carta> iter = getIterator();
		Carta unaCarta;
		int index = 1;
		boolean esta = false;
		while(iter.hasNext() && !esta) {
			unaCarta = iter.next();
			if(unaCarta.getFuerza() > pFuerza) {
				esta = true;
			}
			else{
				index ++;

			}
		}
		return index;
	}
	public int posCarta(int pFuerza) {
		//Dada una lista desordenada y una fuerza devuelve la posicion en la que se le a�adiria en la lista
		Iterator<Carta> iter = getIterator();
		Carta unaCarta;
		int index = 1;
		boolean esta = false;
		while(iter.hasNext() && !esta) {
			unaCarta = iter.next();
			if(unaCarta.getFuerza() == pFuerza) {
				esta = true;
			}
			else {
				index++;
			}
		}
		return index;
	}
	public boolean esta(int pFuerza) {
		Iterator<Carta> iter = getIterator();
		boolean esta = false;
		while(iter.hasNext() && !esta) {
			Carta unaCarta = iter.next();
			if(unaCarta.getFuerza() == pFuerza) {
				esta = true;
			}
		}
		return esta;
	}
	public void anadirInd(int pIndex,Carta pCarta) {
		agregarCartaEnPos(pIndex, pCarta);
		Cola.getCola().notificar();
		//Notificamos el cambio realizado
	}
	public ArrayList<Integer> getApariciones(int pFuerza){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		Iterator<Carta> iterCola = getIterator();
		int posicion = 1;
		while(iterCola.hasNext()) {
			Carta cartaActual = iterCola.next();
			if (cartaActual.getFuerza()==pFuerza) {
				lista.add(posicion);
			}
			posicion ++;
		}
		return lista;
		
	}
	public void moverCarta(int pIndInic, int pIndDest) {
		Carta unaCarta = eliminarCartaEnPos(pIndInic);
		anadirInd(pIndDest, unaCarta);
		Cola.getCola().notificar();
		//Notificamos el cambio realizado
	}
	public void anadirCarta(Carta pCarta) {
		agregarCarta(pCarta);
		Cola.getCola().notificar();
		//Notificamos el cambio realizado
	}
	public void hacerRecurrencia(Carta pCarta) {
		Carta unaCarta;
		for(int pos = 1; pos<=size();pos++) {
			unaCarta = getCartaEnPos(pos);
			if((unaCarta instanceof Recurrencia) && (!(unaCarta.equals(pCarta)))) {
				((Recurrencia) unaCarta).recurrir(pos);
				Cola.getCola().notificar();
			}
		}//Notificamos el cambio realizado
	}
	public ListaCartas invertirOrden() {
		ListaCartas l = new ListaCartas();
		int cont = size();
		while(cont > 0) {
			Carta unaCarta = getCartaEnPos(cont);
			l.agregarCarta(unaCarta);
			cont --;
		}
		return l;
	}
	public void editarCola(ArrayList<Carta> pLista) {
		lCartas = pLista;
		Cola.getCola().notificar();

	}
	public int getPosicion(Carta pCarta) {
		Iterator<Carta> iter = getIterator();
		Carta unaCarta;
		int pos = 1;
		boolean encontrado = false;
		while(iter.hasNext() && !encontrado) {
			unaCarta = iter.next();
			if((unaCarta.equals(pCarta))) {
				encontrado = true;
			}
			else{
				pos ++;
			}
		}
		return pos;
	}
	public void eliminarCarta(Carta pCarta) {
		borrarCarta(pCarta);
	}
	public void estaLlena(){
		if(size()==5) {
			colaLlena();
			Cola.getCola().setLlena();
		}
		Cola.getCola().notificar();
	}

	public void colaLlena() {
		// No hace falta ningun loop ya que sabes que hay exactamente 5 cartas y no usan los mismos metodos.
		Iterator<Carta> iter = getIterator();
		ArrayList<Carta> l = new ArrayList<Carta>();
		Carta unaCarta = iter.next();
		Bar.getBar().anadirCarta(unaCarta);
		unaCarta = iter.next();
		Bar.getBar().anadirCarta(unaCarta);
		unaCarta = iter.next();
		l.add(unaCarta);
		unaCarta = iter.next();
		l.add(unaCarta);
		unaCarta = iter.next();
		Fuera.getFuera().anadirCarta(unaCarta);
		editarCola(l);
	}
	public Carta getUltimaCarta() {
		int size = Cola.getCola().size();
		return getCartaEnPos(size);
	}
	public int cartasDeColor(EnumColor pColor) {
		Iterator<Carta> iter = getIterator();
		Carta unaCarta;
		int cuant = 0;
		while(iter.hasNext()) {
			unaCarta = iter.next();
			if(unaCarta.color.equals(pColor)) {
				cuant++;
			}
		}
		return cuant;
	}
	public int mismoColorDosPrimerosEnFila(EnumColor pColor) {
		int i = 0;
		for(int ind=1;ind>2;ind++) {
			if(getCartaEnPos(ind).color.equals(pColor)) {
				i++;
			}
		}
		return i;
	}
	public boolean hayRecurrentes() {
		Iterator<Carta> iter = getIterator();
		Carta unaCarta;
		boolean hay = false;
		while(iter.hasNext() && !hay) {
			unaCarta = iter.next();
			if(unaCarta instanceof Recurrencia) {
				hay = true;
			}
		}
		return hay;
	}
	public void aLeon() {
		Carta pCarta = getUltimaCarta();
		eliminarCarta(pCarta);
		if(esta(12)) {
			Fuera.getFuera().anadirCarta(pCarta);
		}
		else {
			eliminarApariciones(4);
			anadirInd(1,pCarta);
		}
	}
	public void aHipopotamo() {
		saltar(size());
	}
	public void aCocodrilo() {
		comerCartas(size());
	}
	public void aSerpiente() {
		ordenar();
	}
	public void aJirafa() {
		if(size()>1) {
			Carta unaCarta = getCartaEnPos(size()-1);
			int f = unaCarta.getFuerza();
			if(f<8){
				saltarPos(size(),1);	
			}
		}
	}
	public void aLoro(int pPos) {
		eliminarCartaEnPos(pPos);
	}
	public void aCanguro(int pS) {
		saltarPos(size(),pS);
	}
	public void aMono() {
		eliminarApariciones(11);
		eliminarApariciones(10);
		ArrayList<Integer> nApariciones = getApariciones(4);
		int i = 0;
		while (i<nApariciones.size()-1){
			if(nApariciones.get(i)-1<0) {
				moverCarta(nApariciones.get(i)-1,1);
			}
			i++;
		}
		moverCarta(size(),1); //El ultimo sera siempre el mono		
	}
	public void aCamaleon(int pDec) {
		Carta animalCopiado = getCartaEnPos(pDec);
		if(!(animalCopiado instanceof Camaleon)) {
			animalCopiado.hacerAnimalada();	
		}
	}
	public void aMofeta() {
		int pos = size();
		Carta pCarta = eliminarCartaEnPos(pos);
		int fP = buscarMayorFuerza();
		if(fP>0) {
			eliminarApariciones(fP);	
		}		
		fP = buscarMayorFuerza();
		if(fP>0) {
			eliminarApariciones(fP);	
		}
		anadirCarta(pCarta);		
	}
	public void aCocodriloR(int pPos) {
		comerCartas(pPos);
	}
	public void comerCartas(int pPosC) {
		int aux = size()-1;
		int pos = pPosC-1;
		Iterator<Carta>iter = invertirOrden().getIterator();
		while(aux-pos>=0) {
			iter.next();
			aux --;
		}
		int acum = 0;
		boolean salir = false;
		while(iter.hasNext() && !salir) {
			Carta pCarta = iter.next();
			if(pCarta.getFuerza()==7) {
				salir = true;
			}
			else if(pCarta.getFuerza()<10) {
				acum ++;
			}
			else {
				salir = true;
			}
		}// Menos uno porque queremos eliminar la carta siguiente //Eliminar linea
		while(acum>0) {
			eliminarCartaEnPos(pos);
			acum--;
			pos--;
		}
	}
	public void saltar(int pPos) {
		int aux = size();
		Iterator<Carta> iter = invertirOrden().getIterator();
		while(aux-pPos>=0) {
			iter.next();
			aux --;
		}
		int acum = 0;
		boolean salir = false;
		while(iter.hasNext() && !salir) {
			Carta pCarta = iter.next();
			if(pCarta.getFuerza()==7) {
				salir = true;
			}
			else if(pCarta.getFuerza()<11) {
				acum ++;
			}
			else {
				salir = true;
			}
		}
		saltarPos(pPos,acum);
	}
	public void saltarPos(int pPos, int pSaltos) {
		while(pSaltos>0) {
			moverCarta(pPos, pPos-1); 
			pPos--;
			pSaltos--;
		}	
	}
	public void aJirafaR(int pPos) {
		if(pPos>1) {
			Carta unaCarta = getCartaEnPos(pPos-1);
			int f = unaCarta.getFuerza();
			if(f<8){
				saltarPos(pPos,1);	

			}
		}		
	}
	public void aHipopotamoR(int pPos) {
		saltar(pPos);		
	}
	public ArrayList<Integer> recurrentesColor(EnumColor pColor) {
		Iterator<Carta> itrCola = getIterator();
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(0);
		l.add(0);
		while (itrCola.hasNext()) {
			Carta cartaAux = itrCola.next();
			if (cartaAux.getColor() == pColor) {
				l.set(0, l.get(0)+1);
			}
			if (cartaAux instanceof Recurrencia) {
				l.set(1, l.get(1)+1);
			}
		}
		return l;
	}
}
