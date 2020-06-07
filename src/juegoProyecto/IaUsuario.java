package juegoProyecto;

import java.util.ArrayList;
import java.util.Iterator;

public class IaUsuario extends Jugador {

	public IaUsuario(String pUsername, int pPGanadas, int pPJugadas, int pCartasMetidas, int pPuntos) {
		super(pUsername, pPGanadas, pPJugadas, pCartasMetidas, pPuntos);
	}

	public void elegirCartaBot() {
		ArrayList<Double> p = sacarProbabilidades(mano);
		Double d = obtenerMejorPuntuacion(p);
		int ind = p.indexOf(d);
		Carta cartaElegida = mano.getCartaEnPos(ind + 1);
		jugarCarta(cartaElegida);

	}

	public ArrayList<Double> sacarProbabilidades(ListaCartas pLista) {// actualizar y rehacer
		Carta cartaAux = null;
		int ind = 0;
		int size = 0;
		size = Cola.getCola().size();
		Double factor = 0.0;
		ArrayList<Double> probabilidades = new ArrayList<Double>();
		ArrayList<Carta> mCartas = new ArrayList<Carta>();
		for (int i = 1; i <= pLista.size(); i++) {
			Carta c = pLista.getCartaEnPos(i);
			mCartas.add(c);
		}
		ListaCartas cCartas = new ListaCartas();
		for (int i = 1; i <= Cola.getCola().size(); i++) {
			Carta c = Cola.getCola().getCartaEnPos(i);
			cCartas.agregarCarta(c);
		}
		Iterator<Carta> itrMano = mCartas.iterator();
		// Damos un valor inicial de 10.0 a todas las cartas en la mano
		for (ind = 1; ind <= pLista.size(); ind++) {
			probabilidades.add(10.0);
		}
		ind = 0;
		if (size == 0) { // 0 CARTAS
			while (itrMano.hasNext()) {
				cartaAux = itrMano.next();
				if (cartaAux.getFuerza() == 1) {
					factor = 0.51;
				} else if (cartaAux.getFuerza() == 2) {
					factor = 0.74;
				} else if (cartaAux.getFuerza() == 3) {
					factor = 0.9;
				} else if (cartaAux.getFuerza() == 4) {
					factor = 0.80;
				} else if (cartaAux.getFuerza() == 5) {
					factor = 0.2;
				} else if (cartaAux.getFuerza() == 6) {
					factor = 0.3;
				} else if (cartaAux.getFuerza() == 7) {
					factor = 1.38;
				} else if (cartaAux.getFuerza() == 8) {
					factor = 1.05;
				} else if (cartaAux.getFuerza() == 9) {
					factor = 0.40;
				} else if (cartaAux.getFuerza() == 10) {
					factor = 0.78;
				} else if (cartaAux.getFuerza() == 11) {
					factor = 0.82;
				} else if (cartaAux.getFuerza() == 12) {
					factor = 0.70;
				}
				actualizarFactores(ind, factor, probabilidades);
				ind++;
			}
		} else if (size == 1) { // 1 CARTAS
			Carta cCola = cCartas.getCartaEnPos(1);
			while (itrMano.hasNext()) {
				cartaAux = itrMano.next();
				if(cCola.getColor().equals(cartaAux.getColor())) {
					if (cartaAux.getFuerza() == 1) {
						if (cCola.getFuerza() == 1) {
							factor = 0.15;
						} else if (cCola.getFuerza() == 2) {
							factor = 0.15;
						} else if (cCola.getFuerza() == 3) {
							factor = 0.15;
						} else if (cCola.getFuerza() == 4) {
							factor = 0.15;
						} else if (cCola.getFuerza() == 5) {
							factor = 0.15;
						} else if (cCola.getFuerza() == 6) {
							factor = 0.15;
						} else if (cCola.getFuerza() == 7) {
							factor = 0.15;
						} else if (cCola.getFuerza() == 8) {
							factor = 0.15;
						} else if (cCola.getFuerza() == 9) {
							factor = 0.15;
						} else if (cCola.getFuerza() == 10) { // Factores bajos porque la mofeta es mejor usarla para //
							factor = 0.15;
						} else if (cCola.getFuerza() == 11) {
							factor = 0.15;
						} else if (cCola.getFuerza() == 12) {
							factor = 0.15;
						}
					} else if (cartaAux.getFuerza() == 2) {
						if (cCola.getFuerza() == 1) {
							factor = 0.16;
						} else if (cCola.getFuerza() == 2) {
							factor = 0.16;
						} else if (cCola.getFuerza() == 3) {
							factor = 0.16;
						} else if (cCola.getFuerza() == 4) {
							factor = 0.16;
						} else if (cCola.getFuerza() == 5) {
							factor = 0.16;
						} else if (cCola.getFuerza() == 6) {
							factor = 0.16;
						} else if (cCola.getFuerza() == 7) {
							factor = 0.16;
						} else if (cCola.getFuerza() == 8) {
							factor = 0.16;
						} else if (cCola.getFuerza() == 9) {
							factor = 0.16;
						} else if (cCola.getFuerza() == 10) {
							factor = 0.16;
						} else if (cCola.getFuerza() == 11) {
							factor = 0.16;
						} else if (cCola.getFuerza() == 12) {
							factor = 0.16;
						}
					} else if (cartaAux.getFuerza() == 3) {
						if (cCola.getFuerza() == 1) {
							factor = 0.7;
						} else if (cCola.getFuerza() == 2) {
							factor = 0.7;
						} else if (cCola.getFuerza() == 3) {
							factor = 0.7;
						} else if (cCola.getFuerza() == 4) {
							factor = 0.7;
						} else if (cCola.getFuerza() == 5) {
							factor = 0.7;
						} else if (cCola.getFuerza() == 6) {
							factor = 0.7;
						} else if (cCola.getFuerza() == 7) {
							factor = 0.75;
						} else if (cCola.getFuerza() == 8) {
							factor = 0.5;
						} else if (cCola.getFuerza() == 9) {
							factor = 0.7;
						} else if (cCola.getFuerza() == 10) {
							factor = 0.10;
						} else if (cCola.getFuerza() == 11) {
							factor = 0.4;
						} else if (cCola.getFuerza() == 12) {
							factor = 0.7;
						}
					} else if (cartaAux.getFuerza() == 4) {
						if (cCola.getFuerza() == 4) {
							factor = 0.70;
						} else if (cCola.getFuerza() == 8) {
							factor = 0.3;
						}
						else if (cCola.getFuerza() == 10) {
							factor = 0.2;
						} else if (cCola.getFuerza() == 11) {
							factor = 0.2;
						} else if (cCola.getFuerza() == 12) {
							factor = 0.8;
						} else {
							factor = 0.35;
						}
					} else if (cartaAux.getFuerza() == 5) {
						factor = 0.1;
					} else if (cartaAux.getFuerza() == 6) {
						if (cCola.getFuerza() == 1) {
							factor = 0.2;
						} else if (cCola.getFuerza() == 2) {
							factor = 0.2;
						} else if (cCola.getFuerza() == 3) {
							factor = 0.2;
						} else if (cCola.getFuerza() == 4) {
							factor = 0.2;
						} else if (cCola.getFuerza() == 5) {
							factor = 0.2;
						} else if (cCola.getFuerza() == 6) {
							factor = 0.2;
						} else if (cCola.getFuerza() == 7) {
							factor = 0.35;
						} else if (cCola.getFuerza() == 8) {
							factor = 0.1;
						} else if (cCola.getFuerza() == 9) {
							factor = 0.2;
						} else if (cCola.getFuerza() == 10) {
							factor = 0.1;
						} else if (cCola.getFuerza() == 11) {
							factor = 0.1;
						} else if (cCola.getFuerza() == 12) {
							factor = 0.35;
						}
					} else if (cartaAux.getFuerza() == 7) {
						if(cCola.getFuerza()<10) {		
							factor = 1.07;
						}
						else {
							factor = 0.4;
						}	
					} else if (cartaAux.getFuerza() == 8) {
						if (cCola.getFuerza() == 7) {
							factor = 1.1;
						} else if(cCola.getFuerza() <7){
							factor = 0.25;
						} else {
							factor = 0.33;
						}
					} else if (cartaAux.getFuerza() == 9) {
						factor = 0.19;
					} else if (cartaAux.getFuerza() == 10) {
						if (cCola.getFuerza() < 10) {
							factor = 0.12;
						} else {
							factor = 0.24;
						}
					} else if (cartaAux.getFuerza() == 11) {
						if (cCola.getFuerza() < 11) {
							factor = 0.18;
						} else {
							factor = 0.27;
						}
					} else if (cartaAux.getFuerza() == 12) {
						if (cCola.getFuerza() == 4) {
							factor = 0.13;
						} else if (cCola.getFuerza() == 12) {
							factor = 0.7;
						} else {
							factor = 0.19;
						}
					}
				}
				else {
					if (cartaAux.getFuerza() == 1) {
						if (cCola.getFuerza() == 1) {
							factor = 0.3;
						} else if (cCola.getFuerza() == 2) {
							factor = 0.3;
						} else if (cCola.getFuerza() == 3) {
							factor = 0.3;
						} else if (cCola.getFuerza() == 4) {
							factor = 0.3;
						} else if (cCola.getFuerza() == 5) {
							factor = 0.3;
						} else if (cCola.getFuerza() == 6) {
							factor = 0.3;
						} else if (cCola.getFuerza() == 7) {
							factor = 1.05;
						} else if (cCola.getFuerza() == 8) {
							factor = 0.8;
						} else if (cCola.getFuerza() == 9) {
							factor = 0.4;
						} else if (cCola.getFuerza() == 10) { // Factores bajos porque la mofeta es mejor usarla para //
							factor = 1.05;
						} else if (cCola.getFuerza() == 11) {
							factor = 1.05;
						} else if (cCola.getFuerza() == 12) {
							factor = 0.50;
						}
					} else if (cartaAux.getFuerza() == 2) {
						if (cCola.getFuerza() == 1) {
							factor = 0.49;
						} else if (cCola.getFuerza() == 2) {
							factor = 0.48;
						} else if (cCola.getFuerza() == 3) {
							factor = 0.47;
						} else if (cCola.getFuerza() == 4) {
							factor = 0.46;
						} else if (cCola.getFuerza() == 5) {
							factor = 0.45;
						} else if (cCola.getFuerza() == 6) {
							factor = 0.44;
						} else if (cCola.getFuerza() == 7) {
							factor = 0.85;
						} else if (cCola.getFuerza() == 8) {
							factor = 0.75;
						} else if (cCola.getFuerza() == 9) {
							factor = 0.43;
						} else if (cCola.getFuerza() == 10) {
							factor = 0.85;
						} else if (cCola.getFuerza() == 11) {
							factor = 0.80;
						} else if (cCola.getFuerza() == 12) {
							factor = 0.45;
						}
					} else if (cartaAux.getFuerza() == 3) {
						if (cCola.getFuerza() == 1) {
							factor = 0.7;
						} else if (cCola.getFuerza() == 2) {
							factor = 0.73;
						} else if (cCola.getFuerza() == 3) {
							factor = 0.72;
						} else if (cCola.getFuerza() == 4) {
							factor = 0.5;
						} else if (cCola.getFuerza() == 5) {
							factor = 0.71;
						} else if (cCola.getFuerza() == 6) {
							factor = 0.70;
						} else if (cCola.getFuerza() == 7) {
							factor = 0.85;
						} else if (cCola.getFuerza() == 8) {
							factor = 0.30;
						} else if (cCola.getFuerza() == 9) {
							factor = 0.70;
						} else if (cCola.getFuerza() == 10) {
							factor = 0.10;
						} else if (cCola.getFuerza() == 11) {
							factor = 0.28;
						} else if (cCola.getFuerza() == 12) {
							factor = 0.83;
						}
					} else if (cartaAux.getFuerza() == 4) {
						if (cCola.getFuerza() == 4) {
							factor = 0.70;
						} else if (cCola.getFuerza() == 8) {
							factor = 0.35;
						}
	
						else if (cCola.getFuerza() == 10) {
							factor = 0.78;
						} else if (cCola.getFuerza() == 11) {
							factor = 0.78;
						} else if (cCola.getFuerza() == 12) {
							factor = 0.64;
						} else {
							factor = 0.5;
						}
					} else if (cartaAux.getFuerza() == 5) {
						factor = 0.2;
						// Camaleon
					} else if (cartaAux.getFuerza() == 6) {
						if (cCola.getFuerza() == 9) {
							factor = 0.1;
						} else if (cCola.getFuerza() == 10) {
							factor = 0.03;
						} else if (cCola.getFuerza() == 11) {
							factor = 0.09;
						} else {
							
						}
					} else if (cartaAux.getFuerza() == 7) {
						factor = 0.85;
					} else if (cartaAux.getFuerza() == 8) {
						if (cCola.getFuerza() < 8) {
							factor = 1.02;
						} else {
							factor = 0.22;
						}
					} else if (cartaAux.getFuerza() == 9) {
						if (cCola.getFuerza() < 8) {
							factor = 0.64;
						} else if (cCola.getFuerza() == 8) {
							factor = 0.58;
						} else {
							factor = 0.20;
						}
					} else if (cartaAux.getFuerza() == 10) {
						if (cCola.getFuerza() < 10) {
							factor = 0.55;
						} else {
							factor = 0.30;
						}
					} else if (cartaAux.getFuerza() == 11) {
						if (cCola.getFuerza() < 11) {
							factor = 0.58;
						} else {
							factor = 0.33;
						}
					} else if (cartaAux.getFuerza() == 12) {
						if (cCola.getFuerza() == 4) {
							factor = 0.71;
						} else if (cCola.getFuerza() == 12) {
							factor = 0.08;
						} else {
							factor = 0.31;
						}
					}
				}
				actualizarFactores(ind, factor, probabilidades);
				ind++;
			}
		} else if (size == 2) { // 2 CARTAS
			Carta cCola = cCartas.getCartaEnPos(1);
			Carta cCola2 = cCartas.getCartaEnPos(2);
			while (itrMano.hasNext()) {
				cartaAux = itrMano.next();
				if(cCola2.getColor().equals(cartaAux.getColor())) {
					if(cCola.getColor().equals(cartaAux.getColor())) {
						if(cartaAux.getFuerza()==1){
							factor = 0.06;
						} else if (cartaAux.getFuerza() == 2) {
							factor = 0.07;
						} else if (cartaAux.getFuerza() == 3) {
							if(Cola.getCola().getApariciones(7).size()>0) {
								factor = 1.0;
							} else {
								factor = 0.2;
							}
						} else if (cartaAux.getFuerza() == 4) {
							factor = 0.6 - (0.25*(Cola.getCola().getApariciones(10).size() + Cola.getCola().getApariciones(11).size()));
						} else if (cartaAux.getFuerza() == 5) {
							ListaCartas c = cCartas;
							if(cCartas.getApariciones(5).size()==0) {
								ArrayList<Double> probabilidadesCola = sacarProbabilidades(c);
								factor = obtenerMejorPuntuacion(probabilidadesCola);
							}
							else {
								factor = 0.2;
							}
						} else if (cartaAux.getFuerza() == 6) {
							factor = 0.28;
							if (Cola.getCola().hayRecurrentes()) {
								factor = factor - 0.12;
							}
							if (Cola.getCola().esta(10)) {
								factor = factor - 0.12;
							}
						} else if (cartaAux.getFuerza() == 7) {
							factor = 0.9;
						} else if (cartaAux.getFuerza() == 8) {
							if (cCola2.getFuerza() < 8) {
								if (cCola.getFuerza() < 8) {
									factor = 1.02;
									if (cCola2.getFuerza() == 7) {
										factor = factor + 0.1;
									}
								} else {
									factor = 0.64;
									if (cCola2.getFuerza() == 7) {
										factor = factor + 0.1;
									}
								}
							} else {
								if (cCola.getFuerza() < 8 && cCola2.getFuerza() >= 10) {
									factor = 0.58;
								} else {
									factor = 0.12;
								}
							}
						} else if (cartaAux.getFuerza() == 9) {
							int n = 2 - Cola.getCola().numCartasMenoresQue(9);
							factor = 0.9;
							factor = factor - ((0.37) * n);
						} else if (cartaAux.getFuerza() == 10) {
							int n = Cola.getCola().numCartasMenoresQue(10);
							factor = 0.7;
							if (Cola.getCola().esta(7)) {
								factor = factor - 0.45;
							}
							factor = factor *((0.24
									) / n);
						} else if (cartaAux.getFuerza() == 11) {
							int n = 2 - Cola.getCola().numCartasMenoresQue(11);
							factor = 0.8;
							if (Cola.getCola().esta(7)) {
								factor = factor - 0.31;
							}
							factor = factor - ((0.4) * n);
						} else if (cartaAux.getFuerza() == 12) {
							if (Cola.getCola().esta(12)) {
								factor = 0.1;
							} else {
								factor = 0.65 + ((0.14) * Cola.getCola().getApariciones(4).size());
							}
						}
					}
					else {
						if(cartaAux.getFuerza()==1){
							factor = 0.18;
						} else if (cartaAux.getFuerza() == 2) {
							factor = 0.31;
						} else if (cartaAux.getFuerza() == 3) {
							if(Cola.getCola().getApariciones(7).size()>0) {
								factor = 1.0;
							} else {
								factor = 0.3;
							}
						} else if (cartaAux.getFuerza() == 4) {
							factor = 0.6 - (0.3 *(cCola2.getFuerza()));
						} else if (cartaAux.getFuerza() == 5) {
							ListaCartas c = cCartas;
							if(cCartas.getApariciones(5).size()==0) {
								ArrayList<Double> probabilidadesCola = sacarProbabilidades(c);
								factor = obtenerMejorPuntuacion(probabilidadesCola);
							}
							else {
								factor = 0.2;
							}
						} else if (cartaAux.getFuerza() == 6) {
							factor = 0.28;
							if (Cola.getCola().hayRecurrentes()) {
								factor = factor - 0.12;
							}
							if (Cola.getCola().esta(10)) {
								factor = factor - 0.12;
							}
						} else if (cartaAux.getFuerza() == 7) {
							factor = 0.9;
						} else if (cartaAux.getFuerza() == 8) {
							if (cCola2.getFuerza() < 8) {
								if (cCola.getFuerza() < 8) {
									factor = 1.02;
									if (cCola2.getFuerza() == 7) {
										factor = factor + 0.1;
									}
								} else {
									factor = 0.64;
									if (cCola2.getFuerza() == 7) {
										factor = factor + 0.1;
									}
								}
							} else {
								if (cCola.getFuerza() < 8 && cCola2.getFuerza() >= 10) {
									factor = 0.58;
								} else {
									factor = 0.12;
								}
							}
						} else if (cartaAux.getFuerza() == 9) {
							int n = 2 - Cola.getCola().numCartasMenoresQue(9);
							factor = 0.9;
							factor = factor - ((0.37) * n);
						} else if (cartaAux.getFuerza() == 10) {
							int n = Cola.getCola().numCartasMenoresQue(10);
							factor = 0.7;
							if (Cola.getCola().esta(7)) {
								factor = factor - 0.45;
							}
							factor = factor *((0.24
									) / n);
						} else if (cartaAux.getFuerza() == 11) {
							int n = 2 - Cola.getCola().numCartasMenoresQue(11);
							factor = 0.8;
							if (Cola.getCola().esta(7)) {
								factor = factor - 0.31;
							}
							factor = factor - ((0.4) * n);
						} else if (cartaAux.getFuerza() == 12) {
							if (Cola.getCola().esta(12)) {
								factor = 0.1;
							} else {
								factor = 0.65 + ((0.14) * Cola.getCola().getApariciones(4).size());
							}
						}
					}
				}
				else {
					if(cartaAux.getFuerza()==1){
						int m = Cola.getCola().sumarPuntos();
						factor = 0.44;
						if(m>=16) {
							m = m - 6;
						}
						factor = factor + (0.05 * m);
					} else if (cartaAux.getFuerza() == 2) {
						int m = Cola.getCola().buscarMayorFuerza();
						factor = 0.14;
						if(m>=9) {
							factor = factor +(m*0.088);
						}
					} else if (cartaAux.getFuerza() == 3) {
						factor = 1.1;
						if (cCola2 instanceof Recurrencia && (cCola.getFuerza() != 7)) {
							factor = factor - 0.6;
						}
						if (Cola.getCola().esta(10)) {
							factor = factor - 0.3;
						}
					} else if (cartaAux.getFuerza() == 4) {
						factor = 0.4 + (0.4*(Cola.getCola().getApariciones(10).size() + Cola.getCola().getApariciones(11).size()));
					} else if (cartaAux.getFuerza() == 5) {
						ListaCartas c = cCartas;
						if(cCartas.getApariciones(5).size()==0) {
							ArrayList<Double> probabilidadesCola = sacarProbabilidades(c);
							factor = obtenerMejorPuntuacion(probabilidadesCola);
						}
						else {
							factor = 0.2;
						}
						
					} else if (cartaAux.getFuerza() == 6) {
						factor = 0.3;
						if (Cola.getCola().hayRecurrentes()) {
							factor = factor - 0.12;
						}
						if (Cola.getCola().esta(10)) {
							factor = factor - 0.12;
						}
					} else if (cartaAux.getFuerza() == 7) {
						factor = 0.35;
					} else if (cartaAux.getFuerza() == 8) {
						if (cCola2.getFuerza() < 8) {
							if (cCola.getFuerza() < 8) {
								factor = 1.25;
								if (cCola2.getFuerza() == 7) {
									factor = factor + 0.13;
								}
							} else {
								factor = 0.85;
								if (cCola2.getFuerza() == 7) {
									factor = factor + 0.23;
								}
							}
						} else {
							if (cCola.getFuerza() < 8 && cCola2.getFuerza() >= 10) {
								factor = 0.86;
							} else {
								factor = 0.14;
							}
						}
					} else if (cartaAux.getFuerza() == 9) {
						int n = 2 - Cola.getCola().numCartasMenoresQue(9);
						factor = 1.15;
						factor = factor - ((0.43) * n);
					} else if (cartaAux.getFuerza() == 10) {
						int n = 2 - Cola.getCola().numCartasMenoresQue(10);
						factor = 1.2;
						if (Cola.getCola().esta(7)) {
							factor = factor - 0.68;
						}
						factor = factor - ((0.21) * n);
					} else if (cartaAux.getFuerza() == 11) {
						int n = 2 - Cola.getCola().numCartasMenoresQue(11);
						factor = 1.25;
						if (Cola.getCola().esta(7)) {
							factor = factor - 0.31;
						}
						factor = factor - ((0.4) * n);
					} else if (cartaAux.getFuerza() == 12) {
						if (Cola.getCola().esta(12)) {
							factor = 0.1;
						} else {
							factor = 0.65 + ((0.14) * Cola.getCola().getApariciones(4).size());
						}
					}
				}
				actualizarFactores(ind, factor, probabilidades);
				ind++;
			}
		} else if (size == 3) { // 3 CARTAS
			Carta cCola = cCartas.getCartaEnPos(1);
			Carta cCola2 = cCartas.getCartaEnPos(2);
			Carta cCola3 = cCartas.getCartaEnPos(3);
			while (itrMano.hasNext()) {
				cartaAux = itrMano.next();
				if (cartaAux.getFuerza() == 1) {
					int n = 3 - Cola.getCola().numCartasMenoresQue(10);
					int m = Cola.getCola().sumarPuntos();
					factor = (0.5) + ((0.2) * n) + (0.013 * m);
				} else if (cartaAux.getFuerza() == 2) {
					int n = Cola.getCola().getApariciones(10).size() + Cola.getCola().getApariciones(11).size();
					int m = Cola.getCola().sumarPuntos();
					factor = (0.60) + ((0.35) * n) + (0.009 * m);
				} else if (cartaAux.getFuerza() == 3) {
					if (cCola3 instanceof Recurrencia) {
						if (cCola2 instanceof Recurrencia) {
							factor = 0.2;
						} else {
							factor = 0.8;
						}
					} else {
						if (cCola2 instanceof Recurrencia) {
							factor = 0.6;
						} else {
							factor = 1.01;
						}
					}
					if (Cola.getCola().esta(10)) {
						factor = factor - 0.14;
					}
				} else if (cartaAux.getFuerza() == 4) {
					factor = 0.4 + (0.35
							* (Cola.getCola().getApariciones(10).size() + Cola.getCola().getApariciones(11).size()));
				} else if (cartaAux.getFuerza() == 5) {
					factor = 1.05; // Camaleon
				} else if (cartaAux.getFuerza() == 6) {
					factor = 0.85;
					if (Cola.getCola().hayRecurrentes()) {
						factor = factor - 0.39;
					}
					if (Cola.getCola().esta(10)) {
						factor = factor - 0.40;
					}
				} else if (cartaAux.getFuerza() == 7) {
					factor = 0.65;
				} else if (cartaAux.getFuerza() == 8) {
					factor = 1.45;
					if (cCola3.getFuerza() < 8) {
						if (cCola2.getFuerza() < 8) {
							if (cCola.getFuerza() < 8) {

							} else {
								factor = factor - 0.35;

							}
						} else {
							factor = factor - 0.65;

						}
					} else {
						factor = factor - 1.0;
					}
					if (Cola.getCola().esta(7)) {
						factor = factor + 0.12;
					}
				} else if (cartaAux.getFuerza() == 9) {
					int n = 3 - Cola.getCola().numCartasMenoresQue(9);
					factor = 1.17;
					factor = factor - ((0.21) * n);
				} else if (cartaAux.getFuerza() == 10) {
					int n = 3 - Cola.getCola().numCartasMenoresQue(10);
					factor = 1.12;
					factor = factor - ((0.24) * n);
				} else if (cartaAux.getFuerza() == 11) {
					int n = 3 - Cola.getCola().numCartasMenoresQue(11);
					factor = 1.20;
					factor = factor - ((0.20) * n);
				} else if (cartaAux.getFuerza() == 12) {
					if (Cola.getCola().esta(12)) {
						factor = 0.18;
					} else {
						factor = 0.71 + ((0.09) * Cola.getCola().getApariciones(4).size());
					}
				}
				actualizarFactores(ind, factor, probabilidades);
				ind++;
			}
		} else if (size == 4) { // 4 CARTAS --- LA COLA SE VA A LLENAR
			// AQUI ESTAMOOOS
			Carta cCola = cCartas.getCartaEnPos(1);
			Carta cCola2 = cCartas.getCartaEnPos(2);
			Carta cCola3 = cCartas.getCartaEnPos(3);
			Carta cCola4 = cCartas.getCartaEnPos(4);
			while (itrMano.hasNext()) {
				cartaAux = itrMano.next();
				if (cartaAux.getFuerza() == 1) {
					int n = 4 - Cola.getCola().numCartasMenoresQue(10);
					int m = Cola.getCola().sumarPuntos();
					factor = (0.3) + ((0.17) * n) + (0.008 * m);
				} else if (cartaAux.getFuerza() == 2) {
					int n = Cola.getCola().getApariciones(10).size() + Cola.getCola().getApariciones(11).size();
					int m = Cola.getCola().sumarPuntos();
					factor = (0.2) + ((0.1) * n) + (0.007 * m);
				} else if (cartaAux.getFuerza() == 3) {
					if (cCola4 instanceof Recurrencia) {
						if (cCola3 instanceof Recurrencia) {
							factor = 0.1;
						} else {
							factor = 0.25;
						}
					} else {
						if (cCola3 instanceof Recurrencia) {
							factor = 0.35;
						} else {
							factor = 0.88;
						}
					}
					if (Cola.getCola().esta(10)) {
						factor = factor - 0.26;
					}
				} else if (cartaAux.getFuerza() == 4) {
					factor = 0.35 + (0.12
							* (Cola.getCola().getApariciones(10).size() + Cola.getCola().getApariciones(11).size()));
				} else if (cartaAux.getFuerza() == 5) {
					factor = 0.6; // Camaleon
				} else if (cartaAux.getFuerza() == 6) {
					factor = 1.41;
					if (Cola.getCola().hayRecurrentes()) {
						factor = factor - 0.55;
					}
					if (Cola.getCola().esta(10)) {
						factor = factor - 0.25;
					}
				} else if (cartaAux.getFuerza() == 7) {
					factor = 0.65;
				} else if (cartaAux.getFuerza() == 8) {
					factor = 1.45;
					if (cCola4.getFuerza() < 8) {
						if (cCola3.getFuerza() < 8) {
							if (cCola2.getFuerza() < 8) {
								if (cCola.getFuerza() < 8) {

								} else {
									factor = factor - 0.3;

								}
							} else {
								factor = factor - 0.4;

							}
						} else {
							factor = factor - 0.55;
						}
					}
					else {
						factor = factor - 0.9;
					}
					if (Cola.getCola().esta(7)) {
						factor = factor + 0.12;
					}
				} else if (cartaAux.getFuerza() == 9) {
					int n = 4 - Cola.getCola().numCartasMenoresQue(9);
					factor = 1.17;
					factor = factor - ((0.21) * n);
				} else if (cartaAux.getFuerza() == 10) {
					int n = 4 - Cola.getCola().numCartasMenoresQue(10);
					factor = 1.0;
					factor = factor - ((0.24) * n);
				} else if (cartaAux.getFuerza() == 11) {
					int n = 4 - Cola.getCola().numCartasMenoresQue(11);
					factor = 1.20;
					factor = factor - ((0.20) * n);
				} else if (cartaAux.getFuerza() == 12) {
					if (Cola.getCola().esta(12)) {
						factor = 0.18;
					} else {
						if (Cola.getCola().esta(4)) {
							factor = 0.8 + ((0.08) * Cola.getCola().getApariciones(4).size());
						} else {
							factor = 1.35;
						}
					}
				}
				actualizarFactores(ind, factor, probabilidades);
				ind++;
			}
		}
		if (size > 0) {
			ArrayList<Integer> lCola = Cola.getCola().recurrentesColor(color);
			ind = 0;
			itrMano = mCartas.iterator();
			while (itrMano.hasNext()) {
				cartaAux = itrMano.next();
				// CLASIFICA LAS CARTAS DEPENDIENDO DE SI PUEDEN SER ADELANTADAS POR UNA
				// RECURRENTE
				if ((cartaAux.getFuerza() == 1) || (cartaAux.getFuerza() == 2) || (cartaAux.getFuerza() == 3)
						|| (cartaAux.getFuerza() == 4) || (cartaAux.getFuerza() == 5) || (cartaAux.getFuerza() == 6)) {
					factor = 1.06 - ((0.7) * lCola.get(1));
				} else if ((cartaAux.getFuerza() == 8) || (cartaAux.getFuerza() == 9) || (cartaAux.getFuerza() == 10)) {
					factor = 1.13 - ((0.7) * lCola.get(1));
				} else if (cartaAux.getFuerza() == 7) {
					factor = 1.00 + ((0.2) * lCola.get(1));
				} else if ((cartaAux.getFuerza() == 11) || (cartaAux.getFuerza() == 12)) {
					factor = 1.02;
				}
				actualizarFactores(ind, factor, probabilidades);

				// CLASIFICARA LAS CARTAS ELIMINATORIAS Y LAS QUE ADELANTAN
				if ((cartaAux.getFuerza() == 1) || (cartaAux.getFuerza() == 10)) {
					factor = 1.0 - (((size - lCola.get(0)) / size) / 3);
				} else if ((cartaAux.getFuerza() == 8) || (cartaAux.getFuerza() == 9) || (cartaAux.getFuerza() == 3)
						|| (cartaAux.getFuerza() == 6) || (cartaAux.getFuerza() == 11)) {
					factor = 1.02;
				} else if (cartaAux.getFuerza() == 2) {
					if (size > lCola.get(0)) {
						factor = 1.15;
					} else {
						factor = 0.5;
					}
				} else if (cartaAux.getFuerza() == 7) {
					factor = 1.0;
				} else if ((cartaAux.getFuerza() == 4) || (cartaAux.getFuerza() == 12)) {
					factor = 1.04 - (0.3) * lCola.get(0);
				}
				actualizarFactores(ind, factor, probabilidades);
				ind++;
			}
		}
		return probabilidades;
	}

	private double obtenerMejorPuntuacion(ArrayList<Double> pList) {
		Double puntMax = 0.0;
		Iterator<Double> itr = pList.iterator();
		if(itr.hasNext()) {
			puntMax = itr.next();
		}
		while (itr.hasNext()) {
			Double punt = itr.next();
			if (punt > puntMax) {
				puntMax = punt;
			}
		}
		return puntMax;
	}

	public double multiplicarFactores(double pN1, double pN2) {
		return pN1 * pN2;
	}

	public ArrayList<Double> actualizarFactores(int pInd, double pFactor, ArrayList<Double> pList) {
		double nuevoFactor = multiplicarFactores(pFactor, pList.get(pInd));
		pList.set(pInd, nuevoFactor);
		return pList;
	}

	public void elegir(Carta pCarta) {
		if (pCarta instanceof Eleccion) {
			if (pCarta.imprimirNombre().equals("canguro")) {
				Carta pCarta1 = Cola.getCola().getCartaEnPos(Cola.getCola().size() - 1);
				Carta pCarta2 = Cola.getCola().getCartaEnPos(Cola.getCola().size() - 2);
				if ((pCarta1 instanceof Cocodrilo) || (pCarta1 instanceof Hipopotamo) || (pCarta1 instanceof Jirafa)) {
					if (pCarta2 instanceof Cebra) {
						((Eleccion) pCarta).hacerAnimaladaD(2);
					} else {
						((Eleccion) pCarta).hacerAnimaladaD(1);

					}
				} else {
					if ((pCarta2 instanceof Cocodrilo) || (pCarta2 instanceof Hipopotamo)
							|| (pCarta2 instanceof Jirafa)) {
						((Eleccion) pCarta).hacerAnimaladaD(1);

					} else {
						((Eleccion) pCarta).hacerAnimaladaD(2);
					}
				}
			} else if (pCarta.imprimirNombre().equals("camaleon")) {
				ListaCartas cCartas = new ListaCartas();
				for (int i = 1; i < Cola.getCola().size(); i++) { // La ultima carta no la grega ya que es el camaleon y
																	// no debe usarla.
					Carta aux = Cola.getCola().getCartaEnPos(i);
					cCartas.agregarCarta(aux);
				}
				ArrayList<Double> a = sacarProbabilidades(cCartas);
				Double d = obtenerMejorPuntuacion(a);
				int ind = a.indexOf(d) + 1;
				((Eleccion) pCarta).hacerAnimaladaD(ind);

			} else { // Mi criterio de preferencia de eliminacion
				if (Cola.getCola().esta(10)) {
					((Eleccion) pCarta).hacerAnimaladaD(Cola.getCola().posCarta(10));
				} else if (Cola.getCola().esta(11)) {
					((Eleccion) pCarta).hacerAnimaladaD(Cola.getCola().posCarta(11));
				} else if (Cola.getCola().esta(7)) {
					((Eleccion) pCarta).hacerAnimaladaD(Cola.getCola().posCarta(7));
				} else if (Cola.getCola().esta(12)) {
					((Eleccion) pCarta).hacerAnimaladaD(Cola.getCola().posCarta(12));
				} else if (Cola.getCola().esta(8)) {
					((Eleccion) pCarta).hacerAnimaladaD(Cola.getCola().posCarta(8));
				} else if (Cola.getCola().esta(9)) {
					((Eleccion) pCarta).hacerAnimaladaD(Cola.getCola().posCarta(9));
				} else if (Cola.getCola().esta(1)) {
					((Eleccion) pCarta).hacerAnimaladaD(Cola.getCola().posCarta(1));
				} else if (Cola.getCola().esta(2)) {
					((Eleccion) pCarta).hacerAnimaladaD(Cola.getCola().posCarta(2));
				} else if (Cola.getCola().esta(3)) {
					((Eleccion) pCarta).hacerAnimaladaD(Cola.getCola().posCarta(3));
				} else if (Cola.getCola().esta(4)) {
					((Eleccion) pCarta).hacerAnimaladaD(Cola.getCola().posCarta(4));
				} else if (Cola.getCola().esta(5)) {
					((Eleccion) pCarta).hacerAnimaladaD(Cola.getCola().posCarta(5));
				} else if (Cola.getCola().esta(6)) {
					((Eleccion) pCarta).hacerAnimaladaD(Cola.getCola().posCarta(6));
				}
			}
		}
	}


}
