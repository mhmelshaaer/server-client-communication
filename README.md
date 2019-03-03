# server-client-communication
A simple server-client architecture communication. You can find three versions of the server, a single message single client server, a multi message single client server and a multi message multi client serve

# How to use:
I'm assuming that you will use Intellij editor
<ul>
  <li>Choose the server version that you want to start, for eaxample the SingleMsgSingleClientServer</li>
  <li>Run the main function of the selected server version</li>
  <li>Now you have to instanciate the client that will communicate with the server. You have 2 options:</li>
      <ul>
          <li>Run the client on the same machine</li>
          <li>Run the client on the another machine</li>
      </ul>
  <li>If tou choose the first option, then use the Junit test class for the selected server</li>
  <li>So if you want to instanciate a client to communicate with the SingleMsgSingleClientServer, run the test class SingleMsgSingleClientServerTesting after running the corressponding server class</li>
  <li>For the second option, all you need to do is to run the main function of the server class you want on a machine, then on the other machine run the main function of the Client class giving it the ip of the server machine on the local network and the port</li>
</ul>
