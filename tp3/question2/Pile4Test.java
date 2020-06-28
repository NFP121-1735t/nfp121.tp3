package question2;

/**
 * Classe-test Pile4Test.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 * 
 *          Les classes-test sont documentées ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont basées sur le document © 2002 Robert A. Ballance intitulé
 *          «JUnit: Unit Testing Framework».
 * 
 *          Les objets Test (et TestSuite) sont associés aux classes à tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          même paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque méthode Test à
 *          exécuter. Il peut y avoir plus d'une méthode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ découvrira
 *          automatiquement (par introspection) les méthodes Test de votre
 *          classe Test et générera la TestSuite conséquente. Chaque appel d'une
 *          méthode Test sera précédé d'un appel de setUp(), qui réalise les
 *          engagements, et suivi d'un appel à tearDown(), qui les détruit.
 */
public class Pile4Test extends junit.framework.TestCase {
	// Définissez ici les variables d'instance nécessaires à vos engagements;
	// Vous pouvez également les saisir automatiquement du présentoir
	// à l'aide du menu contextuel "Présentoir --> Engagements".
	// Notez cependant que ce dernier ne peut saisir les objets primitifs
	// du présentoir (les objets sans constructeur, comme int, float, etc.).
	private PileI p1;
	private PileI p2;

	/**
	 * Constructeur de la classe-test Pile4Test
	 */
	public Pile4Test() {
	}

	/**
	 * Met en place les engagements.
	 * 
	 * Méthode appelée avant chaque appel de méthode de test.
	 */
	protected void setUp() // throws java.lang.Exception
	{
		// Initialisez ici vos engagements
		p1 = new question2.Pile4();
		p2 = new question2.Pile4();

	}

	/**
	 * Supprime les engagements
	 * 
	 * Méthode appelée après chaque appel de méthode de test.
	 */
	protected void tearDown() // throws java.lang.Exception
	{
		// Libérez ici les ressources engagées par setUp()
	}


	public void test_pile4_capacite()
	{
		assertEquals(PileI.CAPACITE_PAR_DEFAUT, p2.capacite());
	}

	public void test_pile4_estPleine() throws Exception
	{
		question2.Pile4 p = new question2.Pile4(3);
		p.empiler(2);
		assertEquals(1, p.taille());
		p.empiler(3);
		assertEquals(2, p.taille());
		p.empiler(2);
		assertEquals(3, p.taille());
		assertEquals(true, p.estPleine());
		assertEquals(p.capacite(), p.taille());
		try{
		    p.empiler(0);
		    fail();
		  }catch (Exception e){
		      assertTrue(e instanceof question1.PilePleineException);
		  }
}
		  
		  
		  
		  
	
	public void test_pile4_estVide() throws Exception
	{
		question2.Pile4 p = new question2.Pile4(2);
		assertEquals(true, p.estVide());
		try{
		    Object t = p.depiler();
		    fail();
		  }catch(Exception e){
		      assertTrue(e instanceof question1.PileVideException);
		  }
}
	
	public void test_pile4_sommet() throws Exception
	{
		question2.Pile4 p = new question2.Pile4(3);
		assertEquals(true, p.estVide());
		p.empiler(3);
		assertEquals("sommet",new Integer(3), p.sommet());
		assertEquals(1, p.taille());
		assertEquals("depiler",new Integer(3), p.depiler());
		assertEquals(0, p.taille());

	}

	public void test_pile4_tailleNegative()
	{
		question2.Pile4 pp = new question2.Pile4(-2);
		assertEquals(PileI.CAPACITE_PAR_DEFAUT, pp.capacite());
	}

	public void test_pile4_toString() throws Exception
	{
		question2.Pile4 p21 = new question2.Pile4(3);
		assertEquals("toString impossible","[]", p21.toString());
		p21.empiler(2);
		assertEquals("toString Possible","[2]", p21.toString());
		p21.empiler(4);
		p21.empiler(6);
		assertEquals("toString possible","[6,4,2]", p21.toString());

	}

	public void test_pile4_eqauls() throws Exception
	{
		p1.empiler(3);
		p1.empiler(7);
		p1.empiler(8);
		p2.empiler(7);
		p2.empiler(8);
		p2.empiler(4);
		assertTrue("egalite de deux piles", p1.equals(p2));
		assertTrue("egalites de deux piles", p2.equals(p1));
		assertTrue("egalite de deux piles", p2.equals(p2));
		p2.empiler(4);
		assertFalse("egalite de deux piles", p1.equals(p2));
	}
}









