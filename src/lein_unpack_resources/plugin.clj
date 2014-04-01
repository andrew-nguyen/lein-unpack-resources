(ns lein-unpack-resources.plugin
  (:require [leiningen.unpack-resources :as r]))

(defn hooks
  []
  (r/hooks))
