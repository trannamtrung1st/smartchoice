<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <jobName>
      <xsl:value-of select="//*[contains(@class,'box_chi_tiet_cong_viec')]//h1[contains(@class,'title_big')]"/>
    </jobName>

    <!--Company name-->
    <xsl:apply-templates select="//*[contains(@class,'box_chi_tiet_cong_viec')]//p[@class='font16']"/>

    <expiredDate>
      <xsl:value-of select="//span[@class='line-icon']//span[@class='text_pink']"/>
    </expiredDate>
    <code>
      <xsl:value-of select="normalize-space(substring-after(//p[@class='text_grey2 font12 mt8 mb12']//span[2], 'Mã:'))"/>
    </code>

    <!--Job detail-->
    <xsl:apply-templates select="//*[contains(@class,'job_detail')]"/>

  </xsl:template>
  <xsl:template match="//*[contains(@class,'box_chi_tiet_cong_viec')]//p[@class='font16']">
    <company>
      <detailUrl>
        <xsl:value-of select="a/@href"/>
      </detailUrl>
      <name>
        <xsl:value-of select="a"/>
      </name>
    </company>
  </xsl:template>
  <xsl:template match="//*[contains(@class,'job_detail')]">
    <salaryRange>
      <xsl:value-of select="//i[contains(@class,'icon-money')]/following-sibling::span/span[@class='job_value']"/>
    </salaryRange>
    <expRequirement>
    </expRequirement>
    <degreeRequirement>
    </degreeRequirement>
    <numOfVacancy>
    </numOfVacancy>
    <workLocation>
    </workLocation>
    <workPosition>
    </workPosition>
    <workingType>
    </workingType>
  </xsl:template>
</xsl:stylesheet>