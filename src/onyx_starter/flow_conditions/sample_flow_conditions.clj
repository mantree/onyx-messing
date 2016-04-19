(ns onyx-starter.flow-conditions.sample-flow-conditions
 )

;; Flow conditions would go here, but we aren't using them for this example.


(def flow-conditions
  [{:flow/from :mult
    :flow/to [:in-again]
    :flow/predicate [:not :onyx-starter.functions.sample-functions/enough?]}
   {:flow/from :mult
    :flow/to [:add-bang]
    :flow/predicate :onyx-starter.functions.sample-functions/enough?}
   ])









