### conda install diagrams
from diagrams import Cluster, Diagram, Edge
from diagrams.custom import Custom
import os
os.environ['PATH'] += os.pathsep + 'C:/Program Files/Graphviz/bin/'

graphattr = {     #https://www.graphviz.org/doc/info/attrs.html
    'fontsize': '22',
}

nodeattr = {   
    'fontsize': '22',
    'bgcolor': 'lightyellow'
}

eventedgeattr = {
    'color': 'red',
    'style': 'dotted'
}
with Diagram('bw24Arch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctxbw24', graph_attr=nodeattr):
          bw24core=Custom('bw24core','./qakicons/symActorWithobjSmall.png')
          bwobserver=Custom('bwobserver','./qakicons/symActorSmall.png')
     with Cluster('ctxsonarbw24', graph_attr=nodeattr):
          datacleaner=Custom('datacleaner(ext)','./qakicons/externalQActor.png')
diag