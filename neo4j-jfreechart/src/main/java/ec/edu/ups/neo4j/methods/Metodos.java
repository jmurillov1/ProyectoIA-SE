/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.neo4j.methods;

/**
 *
 * @author jmurillo
 */
import ec.edu.ups.neo4j.model.Nodo;
import java.util.ArrayList;
import java.util.List;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Record;
import org.neo4j.driver.Session;
import org.neo4j.driver.Result;
import org.neo4j.driver.Transaction;
import static org.neo4j.driver.Values.parameters;

public class Metodos implements AutoCloseable {

    private final Driver driver;

    public Metodos() {
        driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "5658"));
    }

    @Override
    public void close() throws Exception {
        driver.close();
    }

    public List<Nodo> similitudEuclideanaL(int[] a) {
        try (Session session = driver.session()) {
            List<Nodo> vec = new ArrayList<>();
            String greeting = session.writeTransaction((Transaction tx) -> {
                Result result = tx.run("MATCH (n:LugarTuristico) "
                        + "UNWIND [n.tam,n.tiendas,n.averdes,n.aextremas,n.gal] AS v "
                        + "WITH n, collect(CASE v WHEN 'Grande'  THEN 3 "
                        + "WHEN 'Mediano' THEN 2 "
                        + "WHEN 'Pequeño'THEN 1 "
                        + "WHEN 'si'THEN 1 "
                        + "WHEN 'no'THEN 0 "
                        + " END) as vector "
                        + "RETURN n.nombre AS Lugar, "
                        + "gds.alpha.similarity.euclideanDistance($a,vector) as Sim ORDER BY Sim"
                        + " ASC", parameters("a", a));
                for (Record record : result.list()) {
                    String nomi = record.get("Lugar").asString();
                    Double costo = record.get("Sim").asDouble();
                    Nodo ns = new Nodo(nomi, costo);
                    vec.add(ns);
                }
                return null;
            });
            return vec;
        }
    }

    public List<Nodo> similitudEuclideanaP(int[] a) {
        try (Session session = driver.session()) {
            List<Nodo> vec = new ArrayList<>();
            String greeting = session.writeTransaction((Transaction tx) -> {
                Result result = tx.run("MATCH (n:Parque) "
                        + "UNWIND [n.tamav,n.agua,n.juegosrecre,n.banios,n.send,n.ani] AS v "
                        + "WITH n, collect(CASE v WHEN 'grande'  THEN 3 "
                        + "WHEN 'mediano' THEN 2 "
                        + "WHEN 'pequeño'THEN 1 "
                        + "WHEN 'si'THEN 1 "
                        + "WHEN 'no'THEN 0 "
                        + " END) as vector "
                        + "RETURN n.nombre AS Parque, "
                        + "gds.alpha.similarity.euclideanDistance($a,vector) as Sim ORDER BY Sim"
                        + " ASC", parameters("a", a));
                for (Record record : result.list()) {
                    String nomi = record.get("Parque").asString();
                    Double costo = record.get("Sim").asDouble();
                    Nodo ns = new Nodo(nomi, costo);
                    vec.add(ns);
                }
                return null;
            });
            return vec;
        }
    }

    public List<Nodo> mismaComunidadPT(String parque, String carac) {
        try (Session session = driver.session()) {
            List<Nodo> vec = new ArrayList<>();
            String greeting = session.writeTransaction((Transaction tx) -> {
                Result result = tx.run("MATCH (p1:Parque {nombre:$parque}) "
                        + "MATCH (p2:Parque) WHERE p1<>p2 "
                        + "RETURN p2.nombre as Nombre, gds.alpha.linkprediction.sameCommunity(p1,p2,$carac) AS score ORDER BY score DESC", parameters("parque", parque, "carac", carac));
                for (Record record : result.list()) {
                    String nomi = record.get("Nombre").asString();
                    Double costo = record.get("score").asDouble();
                    Nodo ns = new Nodo(nomi, costo);
                    vec.add(ns);
                }
                return null;
            });
            return vec;
        }
    }

    public List<Nodo> mismaComunidadP1(String parque1, String parque2, String carac) {
        try (Session session = driver.session()) {
            List<Nodo> vec = new ArrayList<>();
            String greeting = session.writeTransaction((Transaction tx) -> {
                Result result = tx.run("MATCH (p1:Parque {nombre:$parque1}) "
                        + "MATCH (p2:Parque {nombre:$parque2}) "
                        + "RETURN p2.nombre as Nombre, gds.alpha.linkprediction.sameCommunity(p1,p2,$carac) AS score ORDER BY score DESC", parameters("parque1", parque1, "parque2", parque2, "carac", carac));
                for (Record record : result.list()) {
                    String nomi = record.get("Nombre").asString();
                    Double costo = record.get("score").asDouble();
                    Nodo ns = new Nodo(nomi, costo);
                    vec.add(ns);
                }
                return null;
            });
            return vec;
        }
    }

    public List<Nodo> mismaComunidadLT(String lugar, String carac) {
        try (Session session = driver.session()) {
            List<Nodo> vec = new ArrayList<>();
            String greeting = session.writeTransaction((Transaction tx) -> {
                Result result = tx.run("MATCH (p1:LugarTuristico {nombre:$lugar}) "
                        + "MATCH (p2:LugarTuristico) WHERE p1<>p2 "
                        + "RETURN p2.nombre as Nombre, gds.alpha.linkprediction.sameCommunity(p1,p2,$carac) AS score ORDER BY score DESC", parameters("lugar", lugar, "carac", carac));
                for (Record record : result.list()) {
                    String nomi = record.get("Nombre").asString();
                    Double costo = record.get("score").asDouble();
                    Nodo ns = new Nodo(nomi, costo);
                    vec.add(ns);
                }
                return null;
            });
            return vec;
        }
    }

    public List<Nodo> mismaComunidadL1(String lugar1, String lugar2, String carac) {
        try (Session session = driver.session()) {
            List<Nodo> vec = new ArrayList<>();
            String greeting = session.writeTransaction((Transaction tx) -> {
                Result result = tx.run("MATCH (p1:LugarTuristico {nombre:$lugar1}) "
                        + "MATCH (p2:LugarTuristico {nombre:$lugar2}) "
                        + "RETURN p2.nombre as Nombre, gds.alpha.linkprediction.sameCommunity(p1,p2,$carac) AS score ORDER BY score DESC", parameters("lugar1", lugar1, "lugar2", lugar2, "carac", carac));
                for (Record record : result.list()) {
                    String nomi = record.get("Nombre").asString();
                    Double costo = record.get("score").asDouble();
                    Nodo ns = new Nodo(nomi, costo);
                    vec.add(ns);
                }
                return null;
            });
            return vec;
        }
    }

    public List<Nodo> degreeCentralyT(String tipoNodo) {
        try (Session session = driver.session()) {
            List<Nodo> vec = new ArrayList<>();
            String greeting = session.writeTransaction((Transaction tx) -> {
                Result result = tx.run("CALL gds.alpha.degree.stream({ "
                        + "  nodeProjection: $tipoNodo, "
                        + "  relationshipProjection: 'CONNECTION' "
                        + "}) "
                        + "YIELD nodeId, score "
                        + "RETURN gds.util.asNode(nodeId).nombre AS Nombre, score AS Salientes "
                        + "ORDER BY Salientes DESC", parameters("tipoNodo", tipoNodo));
                for (Record record : result.list()) {
                    String nomi = record.get("Nombre").asString();
                    Double costo = record.get("Salientes").asDouble();
                    Nodo ns = new Nodo(nomi, costo);
                    vec.add(ns);
                }
                return null;
            });
            return vec;
        }
    }

    public List<Nodo> degreeCentralyTR(String tipoNodo) {
        try (Session session = driver.session()) {
            List<Nodo> vec = new ArrayList<>();
            String greeting = session.writeTransaction((Transaction tx) -> {
                Result result = tx.run("CALL gds.alpha.degree.stream({ "
                        + "  nodeProjection: $tipoNodo, "
                        + "  relationshipProjection: { "
                        + "    CONNECTION: { "
                        + "      type: 'CONNECTION', "
                        + "      orientation: 'REVERSE' "
                        + "    } "
                        + "  } "
                        + "}) "
                        + "YIELD nodeId, score "
                        + "RETURN gds.util.asNode(nodeId).nombre AS Nombre, score AS Entrantes "
                        + "ORDER BY Entrantes DESC", parameters("tipoNodo", tipoNodo));
                for (Record record : result.list()) {
                    String nomi = record.get("Nombre").asString();
                    Double costo = record.get("Entrantes").asDouble();
                    Nodo ns = new Nodo(nomi, costo);
                    vec.add(ns);
                }
                return null;
            });
            return vec;
        }
    }

    public List<Nodo> dfs(String tipoNodo, String inicio, String fin) {
        String query = "MATCH (a:" + tipoNodo + "{nombre:'" + inicio + "'}), (d:" + tipoNodo + "{nombre:'" + fin + "'}) ";
        System.out.println(query);
        if (!verify(tipoNodo)) {
            createGraph(tipoNodo);
        }
        try (Session session = driver.session()) {
            List<Nodo> vec = new ArrayList<>();
            String greeting = session.writeTransaction((Transaction tx) -> {
                Result result = tx.run(query
                        + "WITH id(a) AS startNode, [id(d)] AS targetNodes "
                        + "CALL gds.alpha.dfs.stream($nombre, {startNode: startNode, targetNodes: targetNodes}) "
                        + "YIELD path "
                        + "UNWIND [ n in nodes(path) | n.nombre ] AS tags "
                        + "RETURN tags", parameters("nombre", "my" + tipoNodo));
                for (Record record : result.list()) {
                    String nomi = record.get("tags").asString();
                    Double costo = 0.00;
                    Nodo ns = new Nodo(nomi, costo);
                    vec.add(ns);
                }
                return null;
            });
            return vec;
        }
    }

    public void createGraph(String tipoNodo) {
        String query = "CALL gds.graph.create('my" + tipoNodo + "','" + tipoNodo + "', 'CONNECTION',{ relationshipProperties: 'costo' })";
        try (Session session = driver.session()) {
            List<Nodo> vec = new ArrayList<>();
            String greeting = session.writeTransaction((Transaction tx) -> {
                Result result = tx.run(query);
                return null;
            });
        }
    }

    public void createGraphMO(String tipoNodo) {
        String query = "CALL gds.graph.create( "
                + "    'mo" + tipoNodo + "', "
                + "    '" + tipoNodo + "', "
                + "    { "
                + "        CONNECTION: { "
                + "            type: 'CONNECTION', "
                + "            orientation: 'UNDIRECTED', "
                + "            properties: ['costo'] "
                + "        } "
                + "    })";
        try (Session session = driver.session()) {
            List<Nodo> vec = new ArrayList<>();
            String greeting = session.writeTransaction((Transaction tx) -> {
                Result result = tx.run(query);
                return null;
            });
        }
    }

    public boolean verify(String tipoNodo) {
        String query = "CALL gds.graph.exists('my" + tipoNodo + "') ";
        boolean res = false;
        try (Session session = driver.session()) {
            List<Nodo> vec = new ArrayList<>();
            boolean greeting = session.writeTransaction((Transaction tx) -> {
                Result result = tx.run(query + "YIELD exists AS n");
                return result.single().get("n").asBoolean();
            });
            res = greeting;
        }
        return res;
    }
    
    public boolean verifyMO(String tipoNodo) {
        String query = "CALL gds.graph.exists('mo" + tipoNodo + "') ";
        boolean res = false;
        try (Session session = driver.session()) {
            List<Nodo> vec = new ArrayList<>();
            boolean greeting = session.writeTransaction((Transaction tx) -> {
                Result result = tx.run(query + "YIELD exists AS n");
                return result.single().get("n").asBoolean();
            });
            res = greeting;
        }
        return res;
    }
    
    public List<Nodo> mo(String tipoNodo) {
        String query = "CALL gds.beta.modularityOptimization.stream('mo"+tipoNodo+"', { relationshipWeightProperty: 'costo' })";
        System.out.println(query);
        if (!verifyMO(tipoNodo)) {
            createGraphMO(tipoNodo);
        }
        try (Session session = driver.session()) {
            List<Nodo> vec = new ArrayList<>();
            String greeting = session.writeTransaction((Transaction tx) -> {
                Result result = tx.run(query +" YIELD nodeId, communityId " +
                                              "RETURN gds.util.asNode(nodeId).nombre AS nombre, communityId " +
                                              "ORDER BY nombre");
                for (Record record : result.list()) {
                    String nomi = record.get("nombre").asString();
                    int idComun= record.get("communityId").asInt();
                    Nodo ns = new Nodo();
                    ns.setCodigo(idComun);
                    ns.setNombre(nomi);
                    vec.add(ns);
                }
                return null;
            });
            return vec;
        }
    }
}
