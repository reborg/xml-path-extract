(ns xml-path-extract.core
  (:require [clojure.tools.cli :refer [cli]]
            [clojure.java.io :as io]
            [clojure.xml :as xml])
  (:gen-class :main true))

(def options [["-f" "--fake" "dry run" :flag true]])

(defn empty-args? [args]
  (empty? (remove #(= "" %) args)))

(defn print-msg-and-exit [msg]
  (do
    (println msg)
    (System/exit 1)))

(defn paths
  ([m] (paths m []))
  ([m k]
   (if (:content m)
     (mapcat #(paths % (conj k (:tag m))) (:content m))
     [k])))

(defn -main [& args]
  (let [[opts args banner] (apply cli args options)]
    (if (:fake opts)
      (print-msg-and-exit "Dry run. Bye."))
    (if (empty-args? args)
      (print-msg-and-exit (str "Missing input file: 'xpe <file>'" banner))
      (let [paths (->> (first args) slurp .getBytes io/input-stream xml/parse paths
                       (map #(apply str (interpose "/" (map name %))))
                       set
                       sort)]
        (println
          (with-out-str
            (clojure.pprint/write paths)))))))
