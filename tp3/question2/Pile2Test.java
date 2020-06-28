package question2;

/**
 * Classe-test Pile2Test.
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
public class Pile2Test extends junit.framework.TestCase {
	// Définissez ici les variables d'instance nécessaires à vos engagements;
	// Vous pouvez également les saisir automatiquement du présentoir
	// à l'aide du menu contextuel "Présentoir --> Engagements".
	// Notez cependant que ce dernier ne peut saisir les objets primitifs
	// du présentoir (les objets sans constructeur, comme int, float, etc.).

	/**
	 * Constructeur de la classe-test Pile2Test
	 */
	private PileI pp;
	private PileI pl;
	public Pile2Test() {
	}

	/**
	 * Met en place les engagements.
	 * 
	 * Méthode appelée avant chaque appel de méthode de test.
	 */
	protected void setUp() // throws java.lang.Exception
	{
	    pp= new question2.Pile2();
	    pl=new question2.Pile2();
		// Initialisez ici vos engagements
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
	 public void testPileCapacite(){
	      assertEquals(PileI.CAPACITE_PAR_DEFAUT , pp.capacite());
	   }
	 public void testPileEstPleine() throws Exception{
	     PileI p = new question2.Pile2(2);
	     p.empiler(4);
	     assertEquals(1, p.taille());
	     p.empiler(7);
	     assertEquals(2, p.taille());
	     
	     assertEquals(true, p.estPleine());
	     assertEquals(p.taille(), p.capacite());
	     try{
	         p.empiler(9);
	         fail();
	       }catch(Exception e){
	           assertTrue(e instanceof question1.PilePleineException);
	       }
	   }
	   public void testSommetPile() throws Exception{
	       PileI p = new question2.Pile2(2);
	       assertEquals(true , p.estVide());
	       p.empiler(new Integer(1));
	       assertEquals( " sommet ??" , new Integer(1) , p.sommet());
	       assertEquals(1, p.taille());
	       assertEquals(" depiler ??" , new Integer(1) , p.depiler());
	       assertEquals(0,p.taille());
	   }
	   
	       

	/**
	 * Il ne vous reste plus qu'à définir une ou plusieurs méthodes de test. Ces
	 * méthodes doivent vérifier les résultats attendus à l'aide d'assertions
	 * assertTrue(<boolean>). Par convention, leurs noms devraient débuter par
	 * "test". Vous pouvez ébaucher le corps grâce au menu contextuel
	 * "Enregistrer une méthode de test".
	 */




	public void test_Pile_estVide() throws Exception {
        PileI p = new question2.Pile2(3);
        assertEquals(true, p.estVide());
        try {
            Object r = p.depiler();
            fail();
        } catch(Exception e){
            assertTrue(e instanceof question1.PileVideException);
        }
    }


 public void test_Pile2_toString() throws Exception {
        question2.Pile2 Pile21 = new question2.Pile2(3);
        assertEquals("toString impossible ", "[]", Pile21.toString());
        Pile21.empiler(4);
        assertEquals("toString possible ", "[4]", Pile21.toString());
        Pile21.empiler(0);
        assertEquals("toString possible ", "[0, 4]", Pile21.toString());
        Pile21.empiler(3);
        assertEquals("toString possible ", "[3, 0, 4]", Pile21.toString());


    }
    

	public void test_Pile2_equals() throws Exception
	{
		pl.empiler(1);
		pl.empiler(2);
		pl.empiler(3);
		pp.empiler(2);
		pp.empiler(1);
		pp.empiler(3);
		assertTrue("egalite de deux piles 1", pl.equals(pp));
		assertTrue("egalite de deux piles 2", pp.equals(pl));
		assertTrue("egalite de de piles 4", pl.equals(pl));
		pp.empiler(1);
		assertFalse("egalite de deux piles 4", pl.equals(pp));
	}

	public void testPile_test_taille_negative()
	{
		question2.Pile2 p = new question2.Pile2(-3);
		assertEquals(p.CAPACITE_PAR_DEFAUT, p.capacite());
	}
}





	  
		    


