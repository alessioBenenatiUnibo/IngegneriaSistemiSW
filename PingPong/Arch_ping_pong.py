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
with Diagram('ping_pongArch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctxpingpong', graph_attr=nodeattr):
          ping=Custom('ping','./qakicons/symActorWithobjSmall.png')
          pong=Custom('pong','./qakicons/symActorWithobjSmall.png')
     pong >> Edge(color='blue', style='solid',  decorate='true', label='<pallina &nbsp; sconfitta &nbsp; vittoria &nbsp; >',  fontcolor='blue') >> ping
     ping >> Edge(color='blue', style='solid',  decorate='true', label='<pallina &nbsp; sconfitta &nbsp; vittoria &nbsp; >',  fontcolor='blue') >> pong
diag
