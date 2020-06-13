<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <xsl:param name="url"/>
    <xsl:param name="code"/>
    <jobItem>
      <url>
        <xsl:value-of select="$url"/>
      </url>
      <code>
        <xsl:value-of select="$code"/>
      </code>
      <!--Job info-->
      <xsl:apply-templates select="//section"/>
    </jobItem>
  </xsl:template>

  <!--Job overview-->
  <xsl:template match="//section">
    <jobName>
      <xsl:value-of select="//*[@id='left-content']/header/h1/span"/>
    </jobName>
    <company>
      <detailUrl>
        <xsl:value-of select="div[3]/h3/a/@href"/>
      </detailUrl>
      <name>
        <xsl:value-of select="div[3]/h3/a"/>
      </name>
    </company>
    <salaryRange>
      <xsl:value-of select="div[6]/div/ul/li[1]/text()"/>
    </salaryRange>
    <expRequirement>
      <xsl:value-of select="div[6]/div/ul/li[2]/text()"/>
    </expRequirement>
    <degreeRequirement>
      <xsl:value-of select="div[6]/div/ul/li[3]/text()"/>
    </degreeRequirement>
    <numOfVacancy>
      <xsl:value-of select="div[7]/ul/li[1]/text()"/>
    </numOfVacancy>
    <careerFields>
      <xsl:for-each select="div[6]/div/ul/li[5]/a">
        <item>
          <xsl:value-of select="."/>
        </item>
      </xsl:for-each>
    </careerFields>
    <workLocations>
      <xsl:for-each select="div[6]/div/ul/li[4]/a">
        <item>
          <xsl:value-of select="."/>
        </item>
      </xsl:for-each>
    </workLocations>
    <genderRequirement>
      <xsl:value-of select="div[7]/ul/li[2]/text()"/>
    </genderRequirement>
    <description>
      <xsl:value-of select="normalize-space(table/tbody/tr[1]/td[2]/p)"/>
    </description>
    <benefit>
      <xsl:value-of select="normalize-space(table/tbody/tr[3]/td[2]/p)"/>
    </benefit>
    <otherRequirement>
      <xsl:value-of select="normalize-space(table/tbody/tr[2]/td[2]/p)"/>
    </otherRequirement>
    <expiredDate>
      <xsl:value-of select="table/tbody/tr[4]/td[2]/b"/>
    </expiredDate>
    <contactPerson>
      <xsl:value-of select="div[9]/div/table/tbody/tr[1]/td[2]/p"/>
    </contactPerson>
    <contactAddress>
      <xsl:value-of select="div[9]/div/table/tbody/tr[2]/td[2]/p"/>
    </contactAddress>
  </xsl:template>
</xsl:stylesheet>