(ns offcourse.fake-data.courses)

(def raw-courses [{:goal    "Become a Frontend Ninja"
                   :checkpoints [{:task "Install React"}
                                 {:task "Build a Component"}
                                 {:task "Create an App"}]}
                  {:goal        "Improve your Backend Chops"
                   :checkpoints [{:task "Install Node"}
                                 {:task "Set up a Route"}
                                 {:task "Add some Middleware"}
                                 {:task "Build an API"}]}
                  {:goal        "Get More Street Cred"
                   :checkpoints [{:task "Talk Dirty with Reika"}
                                 {:task "Pair with Greg"}
                                 {:task "Scheme with Charlotte"}
                                 {:task "Brawl with Yeehaa"}]}
                  {:goal        "Make DevOps Your Thing"
                   :checkpoints [{:task "Tame the Command Line"}
                                 {:task "Just Git It"}
                                 {:task "Try a PAAS"}
                                 {:task "Make Containers"}
                                 {:task "Do it All"}]}])
