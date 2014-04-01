(defproject lein-unpack-resources "0.1.0"
  :description "Fetches a maven-based jar and unpacks it and adds it as a resource"
  :url "https://github.com/andrew-nguyen/lein-unpack-resources"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/java.classpath "0.2.2"]
                 [net.lingala.zip4j/zip4j "1.3.2"]]
  :deploy-repositories [["clojars" {:sign-releases false}]]
  :eval-in-leiningen true)
