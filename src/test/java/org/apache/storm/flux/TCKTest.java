package org.apache.storm.flux;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.generated.StormTopology;
import backtype.storm.utils.Utils;
import org.apache.storm.flux.model.TopologyDef;
import org.apache.storm.flux.parser.FluxParser;
import org.junit.Test;
import static org.junit.Assert.*;

public class TCKTest {
    @Test
    public void testTCK() throws Exception {
        TopologyDef topologyDef = FluxParser.parse("src/test/resources/configs/tck.yaml");

        // merge contents of `config` into topology config
        Config conf = FluxMain.buildConfig(topologyDef);
        StormTopology topology = FluxMain.buildTopology(topologyDef);
        assertNotNull(topology);
        topology.validate();
    }

    @Test
    public void testShellComponents() throws Exception {
        TopologyDef topologyDef = FluxParser.parse("src/test/resources/configs/shell_test.yaml");

        // merge contents of `config` into topology config
        Config conf = FluxMain.buildConfig(topologyDef);
        StormTopology topology = FluxMain.buildTopology(topologyDef);
        assertNotNull(topology);
        topology.validate();
    }
}
