(ns leiningen.unpack-resources
  (:require [clojure.java.classpath :as cp]
            [clojure.pprint :as pprint]
            [leiningen.deps :refer [deps]]
            [leiningen.jar :as lein.jar]
            [leiningen.core.project :as project])
  (:import [net.lingala.zip4j.core ZipFile]
           [net.lingala.zip4j.exception ZipException]))

(defn jar-name
  [group artifact version ext]
  (if (and group artifact)
    (str group "-" artifact "-" version "." ext)
    (str group "-" version "." ext)
    ))

(defn get-jar-files
  [project]
  (filter (memfn isFile) (deps project)))

(defn unzip-file
  [zip dest]
  (try
    (-> (ZipFile. zip)
        (.extractAll dest))
    (catch ZipException e
      (.printStackTrace e)
      e)))

(defn unpack-resources
  [project & args]
  (let [resource (get-in project [:unpack-resources :resource])
        group-artifact (first resource)
        version (second resource)
        extract-path (get-in project [:unpack-resources :extract-path])
        [group artifact] (clojure.string/split (name group-artifact) #"/")
        classpath-jars (get-jar-files (update-in project [:dependencies] conj resource))
        jar-name (jar-name group artifact version "jar")
        ]
    (if-let [jar-file (first (filter #(.endsWith (.getName %) jar-name) classpath-jars))]
      (let [jar-file-path (.getAbsolutePath jar-file)]
        (println "Extracting:  " jar-file-path)
        (println "Destination: " extract-path)
        (unzip-file jar-file-path extract-path))
      (println "Please specify a valid resource and extract path"))
    ))
